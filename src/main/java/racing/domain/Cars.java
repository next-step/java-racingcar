package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(Players players) {
        this.cars = initCars(players);
    }

    private List<Car> initCars(Players players) {
        return players.getPlayers().stream()
                .map(player -> new Car(player, CarPosition.ofStartingPoint()))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void race(MovingStrategy strategy) {
        for (Car car : cars) {
            car.race(strategy);
        }
    }

    public Set<String> getWinnerCarsName() {
        return new WinnerCars(cars).selectWinnersName();
    }

}
