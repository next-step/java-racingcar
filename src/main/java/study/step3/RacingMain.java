package study.step3;

public class RacingMain {
  public static void main(String[] args) {
    InputView inputView = new InputView();
    int carNumber = inputView.inputCarNumber();
    int times = inputView.inputTimes();

    CarRace carRace = new CarRace(carNumber, times);
    carRace.start();
  }

}
