package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {

    private List<Car> cars = new ArrayList<>();
    public RacingCars(int carCount) {
        this.cars = createCars(carCount);
    }


    public int numberOfParticipants() {
        return cars.size();
    }


    public void moveCar() {
        for (Car car : cars) {
            car.moveForward(RandomStep.step());
        }
    }


    private List<Car> createCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public List<Car> getRacingCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
