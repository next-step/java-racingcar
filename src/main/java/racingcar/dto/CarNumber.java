package racingcar.dto;

public class CarNumber {

  private final int carNumber;

  public CarNumber(String numberString) {
    this.carNumber = toInt(numberString);
  }

  public int carNumber() {
    return this.carNumber;
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
