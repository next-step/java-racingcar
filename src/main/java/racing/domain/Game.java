package racing.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import racing.exception.GameException;

public class Game {
    private static final int RANDOM_BOUND_UNDER = 10;
    private static final Random RANDOM = new Random();

    private NumberOfRound numberOfRound;
    private final List<Car> cars = new LinkedList<>();

    public Game(final NumberOfRound numberOfRound) {
        this.numberOfRound = numberOfRound;
    }

    public List<Car> equipRacingCar(final NumberOfCars numberOfCars) {
        int index = 0;
        NumberOfCars addCarsIndex = NumberOfCars.of(index);
        while (!addCarsIndex.equals(numberOfCars)) {
            cars.add(new Car());
            addCarsIndex = NumberOfCars.of(++index);
        }
        return cars;
    }

    public boolean isLeftRound() {
        return !this.numberOfRound.equals(NumberOfRound.of(0));
    }

    public void proceedRound() {
        if (!isLeftRound()) {
            throw new GameException("모든 Round가 종료되었습니다.");
        }
        cars.forEach(car -> car.run(RANDOM.nextInt(RANDOM_BOUND_UNDER)));
        this.numberOfRound = this.numberOfRound.decrease();
    }
}
