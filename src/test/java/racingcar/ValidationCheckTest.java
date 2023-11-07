package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.ValidationCheck;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
//    @Test
//    @DisplayName("입력값이 null이나 빈문자가 들어오면 오류가 나는지 테스트")
//    public void ValidationCheck_null_빈문자() {
//        assertThatThrownBy(() -> ValidationCheck.checkInputCarCount(null)).isInstanceOf(NullPointerException.class);
//    }
//
//    @Test
//    @DisplayName("입력값이 음수값이 들어오면 오류가 나는지 테스트")
//    public void ValidationCheck_음수() {
//        assertThatThrownBy(() -> ValidationCheck.checkInputCarCount(-1)).isInstanceOf(IllegalArgumentException.class);
//    }
//
//    @Test
//    @DisplayName("입력값이 숫자가 아닌 문자가 들어오면 오류가 나는지 테스트")
//    public void ValidationCheck_문자() {
//        String input = "a";
//        assertThatThrownBy(() -> ValidationCheck.checkInputCarCount(Integer.parseInt(input))).isInstanceOf(IllegalArgumentException.class);
//    }
}
