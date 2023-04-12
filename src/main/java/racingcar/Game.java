package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int LOW_LIMIT_NUMBER = 1;
    private final int carAmount;
    private final int tryAmount;
    private final List<Car> cars;

    public Game(final int carAmount, final int tryAmount) {
        validate(carAmount, tryAmount);
        this.carAmount = carAmount;
        this.tryAmount = tryAmount;
        this.cars = createCars();
    }

    private void validate(int carAmount, int tryAmount) {
        if (carAmount < LOW_LIMIT_NUMBER) {
            throw new IllegalArgumentException("자동차 대수는 "+LOW_LIMIT_NUMBER+" 이상이어야 합니다.");
        }
        if (tryAmount < LOW_LIMIT_NUMBER) {
            throw new IllegalArgumentException("시도 횟수는 "+LOW_LIMIT_NUMBER+" 이상이어야 합니다.");
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
        for (int i = 0; i < carAmount; i++) {
            cars.get(i).move(RandomNumber.getNumber());
        }
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carAmount; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}
