package step3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacing {
    private final List<Car> carList;

    public CarRacing(String[] carsName) {
        this.carList = makeRacingCars(carsName);
    }

    private List<Car> makeRacingCars(String[] carsName) {
        List<Car> racingCars = new ArrayList<>();

        for (String carName : carsName) {
            racingCars.add(new Car(carName));
        }

        return racingCars;
    }

    public void moveForward() {
        for (Car car : carList) {
            car.moveForward(RandomUtil.makeRandomNumber(), num -> num >= 4);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> findWinnerCarNames() {
        return carList.stream()
                .filter(car -> car.isWinner(getMaxCurrentPosition()))
                .map(Car::getCarName)
                .collect(Collectors.toList());

    }

    private int getMaxCurrentPosition() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getCurrentPosition))
                .orElseThrow(NoSuchElementException::new)
                .getCurrentPosition();
    }
}
