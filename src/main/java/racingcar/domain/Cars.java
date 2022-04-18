package racingcar.domain;

import racingcar.DefaultMovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList;

    private Cars(List<Car> cars) {
        this.carList = cars;
    }

    public void move(List<Integer> moveCounts) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.move(moveCounts.get(i));
        }
    }

    public List<Integer> getCurrentLocations() {
        return carList.stream()
                .map(Car::getCurrentLocation)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }

    public static Cars generateCars(String[] carNames) {
        return new Cars(Arrays.stream(carNames)
                .map(name -> new Car(name, new DefaultMovingStrategy()))
                .collect(Collectors.toList()));
    }

    public String getWinners() {
        Integer winnerLocation = getWinnerLocation();

        return carList.stream()
                .filter(c -> c.getCurrentLocation() == winnerLocation)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private Integer getWinnerLocation() {
        return this.carList.stream()
                .mapToInt(Car::getCurrentLocation)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

}
