package step3;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewTest {

  @Test
  void getInput() {
    InputView inputView = new InputView();
    Assertions.assertThat(inputView.getInput())
        .isNotNull();
  }
}