package racingcar;

public class Game {

    private final int carAmount;
    private final int tryAmount;
    private final Car[] cars;

    public Game(final int carAmount, final int tryAmount) {
        validate(carAmount, tryAmount);
        this.carAmount = carAmount;
        this.tryAmount = tryAmount;
        this.cars = createCars();
    }

    private void validate(int carAmount, int tryAmount) {
        if (carAmount < 1) {
            throw new IllegalArgumentException("자동차 대수는 1 이상이어야 합니다.");
        }
        if (tryAmount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public int getCarAmount() {
        return carAmount;
    }

    public int getTryAmount() {
        return tryAmount;
    }

    public void start() {
        OutputView.printExecutionResult();
        for (int i = 0; i < tryAmount; i++) {
            play();
            OutputView.printCarPosition(cars);
        }
    }

    private void play() {
        for (int j = 0; j < carAmount; j++) {
            cars[j].push(RandomNumber.getNumber());
        }
    }

    private Car[] createCars() {
        Car[] cars = new Car[carAmount];
        for (int i = 0; i < carAmount; i++) {
            cars[i] = new Car();
        }
        return cars;
    }
}
