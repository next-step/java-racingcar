package racingcar.v1.domain;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private List<Car> carList;
    private int rotationLeft;

    public RacingGame(String carNames, int rotation) {
        this.carList = getCarList(carNames);
        this.rotationLeft = rotation;
    }

    public List<Car> getCarList(String cars) {
        String[] carNames = cars.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public boolean isEnd() {
        return this.rotationLeft <= 0;
    }

    public List<Car> getCarList() {
        return this.carList;
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
        if (next >= 4) {
            return 1;
        }
        return 0;
    }

    public List<String> getWinners() {

        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(-1);

        return carList.stream()
                .filter(car -> car.getDistance() >= maxDistance)
                .map(Car::getName)
                .collect(toList());
    }
}
