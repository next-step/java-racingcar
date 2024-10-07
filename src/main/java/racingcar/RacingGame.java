package racingcar;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarName();
        Race race = new Race(carNames);
        int racingCount = InputView.getRacingCount();

        ResultView.printMessage();
        for (int i = 0; i < racingCount; i++) {
            race.run();
            ResultView.printResult();
        }
        ResultView.printWinners();
    }
}
