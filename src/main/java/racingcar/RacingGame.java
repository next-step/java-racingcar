package racingcar;

public class RacingGame {
    private final Screen screen = new Screen();
    private final Console console = new Console();

    private Cars cars;
    private int gameCount;

    public void start() {
        participantApplication();
        playCount();
        playGame();
    }

    public int participantCount() {
        return cars.size();
    }

    public int gameCount() {
        return gameCount;
    }

    private void participantApplication() {
        screen.print("자동차 대수는 몇 대 인가요?");
        addCar(console.inputInt());
    }

    private void playCount() {
        screen.print("시도할 회수는 몇 회 인가요?");
        gameCount = console.inputInt();
    }

    private void addCar(int number) {
        cars = new Cars(number);
    }

    private void playGame() {
        for (int i = 0; i < gameCount; i++) {
            cars.moveAll();
            screen.print(cars.distanceDriven());
        }
    }
}
