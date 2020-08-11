package mvc.domain.car;

import mvc.common.RandomGenerator;
import mvc.domain.dto.CarState;
import mvc.domain.dto.StateOfCars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final Car[] cars;

    private Cars(String[] namesOfCars) {
        int size = namesOfCars.length;

        this.cars = new Car[size];

        for (int i = 0; i < size; ++i) {
            cars[i] = Car.createCar(namesOfCars[i]);
        }
    }

    public static Cars createAllCars(String[] namesOfCars) {
        return new Cars(namesOfCars);
    }

    public void moveCars() {
        for (Car car : this.cars) {
            int fuel = RandomGenerator.generateRandomInt();

            car.move(fuel);
        }
    }

    public StateOfCars getStates() {
        List<CarState> states = new ArrayList<>();

        for (Car car : this.cars) {
            states.add(car.getState());
        }

        return StateOfCars.makeCarStateList(states);
    }

    private int getMaxPosition() {
        CarState maxState =  Arrays.stream(this.cars)
                .max(Car::compareTo)
                .map(Car::getState)
                .orElseThrow(()->new NoSuchElementException("승자가 없습니다."));

        return maxState.getPosition();
    }

    public List<String> findByMaxPosition() {
        int maxPosition = getMaxPosition();

        return Arrays.stream(this.cars)
                .filter(car -> car.equalsPosition(maxPosition))
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
