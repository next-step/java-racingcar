package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars(List<Car> carList) {
        this.carList = carList;
    }

    public static RacingCars of(String[] carNameList, MoveStrategy moveStrategy) {
        return new RacingCars(
                Arrays.stream(carNameList)
                        .map(name -> new Car(name, 0, moveStrategy))
                        .collect(Collectors.toList()));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveCars() {
        carList.forEach(car -> {
            car.move();
        });
    }

    public List<String> getWinners() {
        return carList.stream()
                .filter(car -> car.getStep() == getMaxStep())
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public int getMaxStep() {
        return carList.stream()
                .mapToInt(car -> car.getStep())
                .max().orElse(-1);
    }
}

