package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;

public class GameLauncher {

    private final List<Car> racingCarList;
    private final int endRaceCount;
    private int currentCount = 0;

    public GameLauncher(List<String> nameList, int endRaceCount) {
        racingCarList = new ArrayList<>();
        for (String name : nameList) {
            racingCarList.add(new RacingCar(name));
        }

        this.endRaceCount = endRaceCount;
    }

    public void moveForwardAll() {
        currentCount ++;
        for (Car car : racingCarList) {
            car.moveForward();
        }
    }

    public boolean isEnd() {
        return endRaceCount <= currentCount;
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

