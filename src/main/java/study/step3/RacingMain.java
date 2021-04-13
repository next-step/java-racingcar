package study.step3;

public class RacingMain {
  public static void main(String[] args) {
    int carNumber = InputView.inputCarNumber();
    int times = InputView.inputTimes();

    CarRace carRace = new CarRace(carNumber, times);
    carRace.start();
  }

}
