package step3;

public class CarRacingController {

    public static void main(String[] args) {
        String carNameString = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        CarRacing carRacing = new CarRacing(carNameString, tryCount);

        ResultView.printResultStart();

        ResultView.printResult(carRacing.racingGameStart());

        ResultView.printWinner(carRacing.extractWinner());
    }
}
