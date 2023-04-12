package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int LOW_LIMIT_NUMBER = 1;
    private final int carAmount;
    private final List<Car> cars;

    public Game(final int carAmount) {
        validate(carAmount);
        this.carAmount = carAmount;
        this.cars = createCars();
    }

    private void validate(int carAmount) {
        if (carAmount < LOW_LIMIT_NUMBER) {
            throw new IllegalArgumentException("자동차 대수는 "+LOW_LIMIT_NUMBER+" 이상이어야 합니다.");
        }
    }

    public int getCarAmount() {
        return carAmount;
    }

    public void play() {
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

    public List<Car> getCars() {
        return cars;
    }
}
