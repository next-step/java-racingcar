package study.racingcar;

public class GameBoard {
    /**
     * 게임을 진행을 담당한다.
     */
    private final InputView inputView;
    private final OutputView outputView;

    public GameBoard() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printCarNumberSign();
        final int numOfCar = inputView.getCarNumber();

        outputView.printTryCountSign();
        final int playCount = inputView.getTryCount();

        outputView.printResultSign();

        final GameCars cars = new GameCars(numOfCar);

        for (int i = 0; i < playCount; i++) {
            playTheGame(cars);
        }
    }

    private void playTheGame(GameCars cars) {
        for (Car car : cars) {
            int randomValue = GameUtils.randomNumber();
            car.move(randomValue);
            outputView.printCarStatus(car);
        }
        outputView.printBlankLine();
    }
}
