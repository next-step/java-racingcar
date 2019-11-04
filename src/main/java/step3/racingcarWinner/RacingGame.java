package step3.racingcarWinner;

public class RacingGame {

  private static String inputValue;
  private static int inputTryCount;

  public RacingGame(String inputValue, int inputTryCount) {
    this.inputValue = inputValue;
    this.inputTryCount = inputTryCount;
  }

  public int splitTextToNumberOfCars(String inputValue) {
    return inputValue.split(",").length;
  }


}
