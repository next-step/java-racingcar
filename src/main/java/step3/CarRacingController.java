package step3;

public class CarRacingController {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        CarRacing carRacing = new CarRacing(carCount,tryCount);

        ResultView.printResultStart();
        carRacing.racingStart();
    }
}
