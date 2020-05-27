package racing.domain;

import racing.util.Dice;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> carList;

    public RacingCars() {
        this.carList = new ArrayList<>();
    }

    public RacingCars(String[] carNameArray) {
        this();
        joinCars(carNameArray);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void carsMove() {
        for (Car car : carList) {
            car.move(Dice.cast());
        }
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    private void joinCars(String[] carNameArray) {
        for (String carName : carNameArray) {
            this.carList.add(new Car(carName.trim()));
        }
    }
}
