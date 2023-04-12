package StringAdder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringAdderTest {
    private StringAdder stringAdder;

    @BeforeEach
    public void setUp() {
        stringAdder = new StringAdder();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열과 null 체크")
    void 빈_문자열과_null(String input) {
        assertThat(stringAdder.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열을 정수로 변환하기")
    void 문자열_to_정수() {
        assertThat(stringAdder.toInt("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("구분자에 따라 문자열 나누기")
    void 구분자_나누기(){
        assertThat(stringAdder.splitString("1,2,3",",")).containsExactly("1","2","3");
    }

    @Test
    @DisplayName("배열 속 문자열 더하기")
    void 숫자_합() {
        String[] numbers = {"1","2","3"};
        assertThat(stringAdder.sumAll(numbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 지정하기")
    void 커스텀_구분자() {
        assertThat(stringAdder.findDelimiter("//;\\n1;2;3")).isEqualTo(";");
    }

    @Test
    @DisplayName("음수일 경우 예외 던지기")
    void 음수_예외() {
        assertThatThrownBy(() -> {
            stringAdder.isPositive("-1");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("input must be a non-negative integer");
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    @DisplayName("배열 속 문자열을 정수로 변환 후 더하기")
    void 문자열_덧셈(String arg) {
        assertThat(stringAdder.splitAndSum(arg)).isEqualTo(6);
    }

    static Stream<String> stringProvider() {
        return Stream.of("1,2,3","1:2:3","//;\\n1;2;3");
    }
}
