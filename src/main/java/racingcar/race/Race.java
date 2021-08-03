package racingcar.race;

import racingcar.car.Car;
import racingcar.car.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    public void startRace(Cars cars) {
        cars.moveCars();
    }

    public List<Car> getRaceWinner(Cars cars) {
        int maxPosition = Collections.max(cars.getCars()).getPosition();
        return cars.getCars().stream().filter(c -> c.getPosition() == maxPosition).collect(Collectors.toList());
    }
}
