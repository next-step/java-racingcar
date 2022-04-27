package racing.domain;

import java.util.LinkedList;
import java.util.List;

import racing.exception.GameException;

public class Game {
    private NumberOfRound numberOfRound;
    private final GameRule gameRule;
    private final List<Car> cars = new LinkedList<>();

    public Game(final NumberOfRound numberOfRound, final GameRule gameRule, final List<String> names) {
        this.numberOfRound = numberOfRound;
        this.gameRule = gameRule;
        equipRacingCar(names);
    }

    private void equipRacingCar(final List<String> names) {
        names.stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    public boolean isLeftRound() {
        return numberOfRound.isLeftRound();
    }

    public void proceedRound() {
        if (!isLeftRound()) {
            throw new GameException("모든 Round가 종료되었습니다.");
        }
        cars.forEach(car -> car.run(gameRule));
        this.numberOfRound = this.numberOfRound.decrease();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Game{" +
               "cars=" + cars +
               '}';
    }
}
