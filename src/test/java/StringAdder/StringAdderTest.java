package StringAdder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.Arrays;
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
    @DisplayName("배열 속 문자열 더하기")
    void 숫자_합() {
        String[] numbers = {"1","2","3"};
        ArrayList<String> numArr = new ArrayList<>(Arrays.asList(numbers));
        assertThat(stringAdder.sumAll(numArr)).isEqualTo(6);
    }

    @Test
    @DisplayName("음수일 경우 예외 던지기")
    void 음수_예외() {
        assertThatThrownBy(() -> {
            new PositiveNumber(-1);
            }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    @DisplayName("배열 속 문자열을 정수로 변환 후 더하기")
    void 문자열_덧셈(String arg) {
        assertThat(stringAdder.splitAndSum(arg)).isEqualTo(6);
    }

    static Stream<String> stringProvider() {
        return Stream.of("1,2,3","1:2:3","//;\n1;2;3");
    }
}
