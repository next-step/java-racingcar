package racingcar.dto;

public class TrialNumber {
  private final int trialNumber;

  public TrialNumber(String numberString) {
    this.trialNumber = toInt(numberString);
  }

  public int trialNumber() {
    return this.trialNumber;
  }

  private int toInt(String input) {
    try {
      return Integer.parseInt(input);
    } catch(NumberFormatException e)  {
      System.out.println("숫자를 입력해 주세요");
      throw new IllegalArgumentException();
    }
  }
}
