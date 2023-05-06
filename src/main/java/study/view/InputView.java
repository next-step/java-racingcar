package study.view;

import study.dto.InputDto;
import study.util.Input;

public class InputView {
  private final Input carInput;
  private final Input countInput;

  public InputView(Input carInput, Input countInput) {
    this.carInput = carInput;
    this.countInput = countInput;
  }

  public InputDto view() {
    String carsStr = carInput.getInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    int tryCount = Integer.parseInt(countInput.getInput("시도할 회수는 몇 회 인가요?"));

    return new InputDto(carsStr, tryCount);
  }
}
