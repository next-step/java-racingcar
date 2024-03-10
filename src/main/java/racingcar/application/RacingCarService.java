package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.MoveCommand;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final MoveCommand moveCommand;

    private final List<Car> cars = new ArrayList<>();

    public RacingCarService(MoveCommand moveCommand) {
        this.moveCommand = moveCommand;
    }

    public void initCars(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> cars() {
        List<Car> copyCars = new ArrayList<>();
        for (Car car : cars) {
            copyCars.add(new Car(car));
        }

        return copyCars;
    }

    public void moveCar() {
        if (cars.isEmpty()) {
            throw new IllegalStateException("차량이 없습니다. 먼저 차량을 만들어주세요.");
        }
        for (Car car : cars) {
            car.move(moveCommand.command());
        }
    }

}
