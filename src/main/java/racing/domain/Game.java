package racing.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Car> findWinner() {
        final Location maxLocation = cars.stream()
                                       .map(Car::getLocation)
                                       .max(Comparator.comparing(location -> location))
                                       .orElse(Location.defaultLocation());
        return cars.stream()
                .filter(car -> car.getLocation().equals(maxLocation))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Game{" +
               "cars=" + cars +
               '}';
    }
}
