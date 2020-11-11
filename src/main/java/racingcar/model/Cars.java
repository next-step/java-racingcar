package racingcar.model;

import racingcar.dto.StepByCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public static Cars of(String[] names, Motor motor) {
        List<Car> cars = Arrays.stream(names)
                .map(name -> new Car(name, motor))
                .collect(toList());

        return new Cars(cars);
    }

    public void run() {
        for (Car car : carList) {
            car.run();
        }
    }

    public List<StepByCar> getStepByCar() {
        return carList.stream()
                .map(Car::buildToStepByCar)
                .collect(Collectors.toList());
    }

    public int sizeOfCar() {
        return carList.size();
    }

    public List<Integer> getPositions() {
        return carList.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
