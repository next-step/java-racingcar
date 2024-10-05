package racingcar;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarName();
        int racingCount = InputView.getRacingCount();
        CarManager carManager = new CarManager(carNames);
        carManager.run(racingCount);
    }
}
