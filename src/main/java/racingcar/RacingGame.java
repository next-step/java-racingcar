package racingcar;

public class RacingGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private Cars cars;
    private int playCount;

    public void start() {
        addCar();
        initPlayCount();
        playGame();
    }

    public int participantCount() {
        return cars.size();
    }

    public int playCount() {
        return playCount;
    }

    private void addCar() {
        cars = new Cars(inputView.participantApplication());
    }

    private void initPlayCount() {
        playCount = inputView.playCount();
    }

    private void playGame() {
        for (int i = 0; i < playCount; i++) {
            cars.moveAll();
        }
        resultView.result(cars.list());
    }
}
