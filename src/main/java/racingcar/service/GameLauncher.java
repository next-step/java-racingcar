package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;

public class GameLauncher {

    private final List<Car> racingCarList;

    public GameLauncher(List<String> nameList) {
        racingCarList = new ArrayList<>();

        for (String name : nameList) {
            racingCarList.add(new RacingCar(name));
        }
    }

    public void moveForwardAll() {
        for (Car car : racingCarList) {
            car.moveForward();
        }
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }

    public List<Car> getWinner() {
        int maxPosition = racingCarList.stream()
            .mapToInt(Car::getPosition)
            .max().getAsInt();

        return racingCarList.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }
}

