package study.step3.view;

import study.step3.utils.MessageUtil;
import study.step3.validator.Validator;

public class InputView {

  // 자동차 입력 횟수
  int carNumber;

  // 반복 횟수
  int times;

  public InputView(int carNumber, int times) {
    this.carNumber = carNumber;
    this.times = times;
  }

  public int getCarNumber() {
    return carNumber;
  }

  public int getTimes() {
    return times;
  }

  public void validateInputValue() {
    Validator.validatorNumber(this.carNumber, MessageUtil.carNumber);
    Validator.validatorNumber(this.times, MessageUtil.carTimes);
  }

}
