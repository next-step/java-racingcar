package racingcar.v1.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private final int MOVE_FORWARD_CONDITION = 4;
    private final int MOVE_UNIT = 1;
    private int rotationLeft;
    private List<Car> carList;

    public RacingGame(String carNames, int rotation) {
        this.carList = parseCarListFromString(carNames);
        this.rotationLeft = rotation;
    }

    public List<Car> parseCarListFromString(String cars) {
        return Arrays.stream(cars.split(","))
                .map(name -> new Car(name.trim()))
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public boolean isEnd() {
        return this.rotationLeft <= 0;
    }

    public void playSingleLoop() {
        for (Car car : carList) {
            car.addDistance(moveForwardRandom());
        }
        --this.rotationLeft;
    }

    public int moveForwardRandom() {
        Random random = new Random();
        int next = random.nextInt(10);
        if (next >= MOVE_FORWARD_CONDITION) {
            return MOVE_UNIT;
        }
        return 0;
    }

    public List<String> getWinners() {
        int maxDistance = getMaxDistance(this.carList);
        return getNamesAbove(this.carList, maxDistance);
    }

    public int getMaxDistance(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(-1);
    }

    public List<String> getNamesAbove(List<Car> carList, int distance) {
        return carList.stream()
                .filter(car -> car.getDistance() >= distance)
                .map(Car::getName)
                .collect(toList());
    }
}
