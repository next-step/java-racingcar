package step3;

public class RacingMain {
    public static void main(String[] args) {
        callRacingGameWithName();
    }

    private static void callRacingGame() {
        InputView inputView = new InputView();
        int carCnt = inputView.inputCarCount();
        int time = inputView.inputTimeCount();
        RacingGame racingGame = new RacingGame(carCnt, time);
        racingGame.racingStart();
        racingGame.printRacing();
    }

    private static void callRacingGameWithName() {
        InputView inputView = new InputView();
        String carsName = inputView.inputCarsName();
        int time = inputView.inputTimeCount();
        RacingGame racingGame = new RacingGame(carsName, time);
        racingGame.racingStart();
        racingGame.printRacingWithName();
        racingGame.printRacingWinner();
    }
}
