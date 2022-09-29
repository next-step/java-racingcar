package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("입력한 자동차 이름이 정상적인지 확인")
    void 자동차_이름_글자수_확인() {
        assertThat(InputView.carNameValidCheck(new String[]{"car1","car2","car3"}))
                .isEqualTo(new String[]{"car1","car2","car3"});
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 에러발생")
    void 자동차_이름_글자수_초과() {
        assertThatThrownBy(() -> InputView.carNameValidCheck(new String[]{"abcde,abcdef,abcd"}))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자이차 이름에 공백이 있다면 공백제거")
    void 차_이름_공백_제거() {
        assertThat(InputView.carNameValidCheck(new String[]{"c  ar1","c ar2","car 3"}))
                .isEqualTo(new String[]{"car1","car2","car3"});
    }
}
