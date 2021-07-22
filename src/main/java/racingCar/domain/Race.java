package racingCar.domain;

import racingCar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars;
    private final int FORWARD_CRITERIA = 4;
    private final static String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";

    public Race(int count) {
        validateInput(count);
        this.cars = addCar(count);
    }

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    private void validateInput(int count) {
        if(count < 1) {
            throw new IllegalArgumentException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private List<Car> addCar(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public Race moveCar() {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            movedCars.add(car.move(RandomNumber.getRandomNumber() >= FORWARD_CRITERIA));
        }
        return new Race(movedCars);
    }

    public List<Car> getCars() {
        return cars;
    }

}
