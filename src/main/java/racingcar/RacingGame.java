package racingcar;

public class RacingGame {
    private final Screen screen = new Screen();
    private final InputView inputView = new InputView();

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
        screen.print("실행 결과");
        for (int i = 0; i < playCount; i++) {
            cars.moveAll();
            screen.print(cars.distanceDriven());
        }
    }
}
