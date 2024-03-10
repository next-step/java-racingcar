package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.MoveCommand;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final MoveCommand moveCommand;

    private final List<Car> cars;

    public RacingCarService(MoveCommand moveCommand, int numberOfCar) {
        this.moveCommand = moveCommand;
        this.cars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car());
        }
    }

    public void repeatMoveCar(int number) {
        for (int i = 0; i < number; i++) {
            moveCar();
        }
    }

    public List<Car> cars() {
        List<Car> copyCars = new ArrayList<>();
        for (Car car : cars) {
            copyCars.add(new Car(car));
        }

        return copyCars;
    }

    private void moveCar() {
        for (Car car : cars) {
            car.move(moveCommand.command());
        }
    }

}
