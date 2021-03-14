package step3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacing {
    private List<Car> carList;

    public CarRacing(String[] carsName) {
        makeRacingCars(carsName);
    }

    private void makeRacingCars(String[] carsName) {
        carList = new ArrayList<>();
        for (String carName : carsName) {
            carList.add(new Car(carName));
        }
    }

    public void moveForward() {
        for (Car car : carList) {
            car.moveForward(RandomUtil.makeRandomNumber(), num -> num >= 4);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> getWinnerCarNames() {
        return carList.stream()
                .filter(car -> car.getCurrentPosition() == getMaxCurrentPosition())
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
