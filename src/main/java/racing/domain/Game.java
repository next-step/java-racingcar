package racing.domain;

import java.util.LinkedList;
import java.util.List;

import racing.exception.GameException;

public class Game {
    private NumberOfRound numberOfRound;
    private final GameRule gameRule;
    private final List<Car> cars = new LinkedList<>();

    public Game(final NumberOfRound numberOfRound, final GameRule gameRule) {
        this.numberOfRound = numberOfRound;
        this.gameRule = gameRule;
    }

    public List<Car> equipRacingCar(final NumberOfCars numberOfCars) {
        int index = 0;
        NumberOfCars addCarsIndex = NumberOfCars.of(index);
        while (!addCarsIndex.equals(numberOfCars)) {
            cars.add(new Car(gameRule));
            addCarsIndex = NumberOfCars.of(++index);
        }
        return cars;
    }

    public boolean isLeftRound() {
        return numberOfRound.isLeftRound();
    }

    public void proceedRound() {
        if (!isLeftRound()) {
            throw new GameException("모든 Round가 종료되었습니다.");
        }
        cars.forEach(Car::run);
        this.numberOfRound = this.numberOfRound.decrease();
    }
}
