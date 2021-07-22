package racingCar.domain;

import racingCar.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> cars = new ArrayList<>();
    private final int FORWARD_CRITERIA = 4;
    private final static String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "자동차 대수는 1대 이상이어야 합니다.";


    public Race(int count) {
        validateInput(count);
        addCar(count);
    }

    private void validateInput(int count) {
        if(count < 1) {
            throw new IllegalArgumentException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private void addCar(int count) {
        for (int i = 0; i < count; i++) {
            this.cars.add(new Car());
        }
    }

    public void moveCar() {
        for(Car car : cars) {
            car = car.move(RandomNumber.getRandomNumber() >= FORWARD_CRITERIA);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
