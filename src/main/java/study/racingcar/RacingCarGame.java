package study.racingcar;

public class RacingCarGame {
    /**
     * 게임을 진행을 담당한다.
     */
    public RacingCarGame() {

    }

    public void run() {
        OutputView.printCarNumberSign();
        final int numOfCar = InputView.getCarNumber();

        OutputView.printTryCountSign();
        final int playCount = InputView.getTryCount();

        OutputView.printResultSign();

        final GameCars cars = new GameCars(numOfCar);

        for (int i = 0; i < playCount; i++) {
            playTheGame(cars);
        }
    }

    private void playTheGame(GameCars cars) {
        for (Car car : cars) {
            int randomValue = GameUtils.randomNumber();
            car.move(randomValue);
            OutputView.printCarStatus(car);
        }
        OutputView.printBlankLine();
    }
}
