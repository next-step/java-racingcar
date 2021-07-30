package step3;

public class CarRacingUI {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        CarRacing carRacing = new CarRacing(carCount);

        ResultView.printResultStart();

        for (int i = 0; i < tryCount; i++) {
            ResultView.printResult(carRacing.racing());
        }
    }
}
