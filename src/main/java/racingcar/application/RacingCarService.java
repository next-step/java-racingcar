package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCommand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarService {
    private final MoveCommand moveCommand;

    private Cars cars;

    public RacingCarService(MoveCommand moveCommand) {
        this.moveCommand = moveCommand;
    }

    public void initCars(List<String> carNames) {
        cars = new Cars(makeCars(carNames));
    }

    private List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public List<Car> cars() {
        return cars.getCars();
    }

    public void moveCar() {
        if (cars == null) {
            throw new IllegalStateException("차량이 없습니다. 먼저 차량을 만들어주세요.");
        }

        cars.move(moveCommand);
    }

    public List<Car> winnerCars() {
        return cars.getWinnerCars();
    }

}
