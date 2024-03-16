package racingcar.step4.view;

public class InputValue {
  private final String inputName;
  private final int tryCount;

  public InputValue(String inputName, int tryCount) {
    this.inputName = inputName;
    this.tryCount = tryCount;
  }

  public String getInputName() {
    return inputName;
  }

  public int getTryCount() {
    return tryCount;
  }
}
