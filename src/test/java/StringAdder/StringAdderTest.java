package StringAdder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAdderTest {
    @Test
    @DisplayName("빈 문자열과 null 체크")
    void 빈_문자열과_null() {
        assertThat(StringAdder.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAdder.splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열을 정수로 변환하기")
    void 문자열_to_정수() {
        assertThat(StringAdder.toInt("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("구분자에 따라 문자열 나누기")
    void 구분자_나누기(){
        assertThat(StringAdder.splitString("1,2,3",",")).containsExactly("1","2","3");
    }

    @Test
    @DisplayName("배열 속 문자열 더하기")
    void 숫자_합() {
        String[] numbers = {"1","2","3"};
        assertThat(StringAdder.sumAll(numbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 지정하기")
    void 커스텀_구분자() {
        assertThat(StringAdder.findDelimiter("//;\\n1;2;3")).isEqualTo(";");
    }

    @Test
    @DisplayName("음수일 경우 예외 던지기")
    void 음수_예외() {
        assertThatThrownBy(() -> {
            StringAdder.isPositive("-1");
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("input must be a non-negative integer");
    }

    @Test
    @DisplayName("배열 속 문자열을 정수로 변환 후 더하기")
    void 문자열_덧셈() {
        assertThat(StringAdder.splitAndSum("1,2,3")).isEqualTo(6);
        assertThat(StringAdder.splitAndSum("1:2:3")).isEqualTo(6);
        assertThat(StringAdder.splitAndSum("//;\\n1;2;3")).isEqualTo(6);

    }
}