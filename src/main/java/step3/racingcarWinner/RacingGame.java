package step3.racingcarWinner;

public class RacingGame {

  private static String inputName;
  private static int inputTryCount;

  public RacingGame(String inputName, int inputTryCount) {
    this.inputName = inputName;
    this.inputTryCount = inputTryCount;
  }

  public int splitTextToNumberOfCars(String inputName) {
    return inputName.split(",").length;
  }


}
