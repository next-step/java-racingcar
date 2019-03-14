package racingcar;

public class MainApplication {
    public static void main(String[] args) {

        int carNumber = InputView.getCarNumber();
        int inputTimes = InputView.getTimes();

        RacingGame racingGame = new RacingGame(carNumber);
        racingGame.gameStart(inputTimes);
    }
}
