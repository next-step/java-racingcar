package racing.domain;

import racing.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    private Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars from(String nameOfCars) {
        validNameOfCars(nameOfCars);
        List<Car> tempCarList = new ArrayList<>();
        String[] arrCarNames = nameOfCars.split(",");
        for (String carName : arrCarNames) {
            tempCarList.add(new Car(carName));
        }
        return new Cars(tempCarList);
    }

    private static void validNameOfCars(String nameOfCars) {
        if (Objects.isNull(nameOfCars) || nameOfCars.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름 입력을 확인해주세요.");
        }
    }

    public void nextRound() {
        carList.forEach(car -> car.move(new RandomMoveStrategy()));
    }

    public List<Car> getCarList() {
        return carList;
    }

    private int getVictoryPosition() {
        return carList.stream()
                .sorted()
                .findFirst()
                .get()
                .getPosition();
    }

    public String getVictoryCarNames() {
        return carList.stream()
                .filter(car -> car.getPosition() >= getVictoryPosition())
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
}
