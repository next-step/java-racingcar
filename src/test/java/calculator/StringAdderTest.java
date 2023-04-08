package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAdderTest {
    @Test
    @DisplayName("입력이 null 또는 빈 문자열일 경우 0을 반환")
    void 빈문자orNull() {
        assertThat(StringAdder.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAdder.splitAndSum("")).isEqualTo(0);
    }

    @Test
    @DisplayName("입력이 숫자 하나일 경우 해당 숫자 반환")
    void 숫자하나() {
        assertThat(StringAdder.splitAndSum("22")).isEqualTo(22);
    }

    @Test
    @DisplayName("입력이 컴마 구분자로 구분된 숫자 두개이면 두 숫자의 합을 반환")
    void 컴마구분자() {
        assertThat(StringAdder.splitAndSum("11,22")).isEqualTo(33);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)")
    void 콜론구분자() {
        assertThat(StringAdder.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    void 커스텀구분자() {
        assertThat(StringAdder.splitAndSum("//;\\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("입력에 음수가 있으면 RuntimeException throw")
    void 음수() {
        assertThatThrownBy(() -> StringAdder.splitAndSum("-1:2")).isInstanceOf(RuntimeException.class);
    }
}
