package step3;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCnt = inputView.inputCarCount();
        int time = inputView.inputTimeCount();
        RacingGame racingGame = new RacingGame(carCnt, time);
        racingGame.racingStart();
        racingGame.printRacing();
    }
}
