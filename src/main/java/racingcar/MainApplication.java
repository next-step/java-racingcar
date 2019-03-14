package racingcar;

public class MainApplication {
    public static void main(String[] args) {

        String[] carNames = InputView.getCarNames();
        int inputTimes = InputView.getTimes();

        RacingGame racingGame = new RacingGame(carNames);
        racingGame.gameStart(inputTimes);
    }
}
