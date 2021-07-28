package step3.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

  @DisplayName("입력 값이 없을때 조회할 경우 예외가 발생한다")
  @Test
  void getInput() {
    InputView inputView = new InputView();
    Assertions.assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(inputView::getInput);
  }
}