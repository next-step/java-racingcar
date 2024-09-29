package racingcar;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.wrapper.PositiveNumber;
import racingcar.util.NumberCreator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final String LINE_BREAK = "\n";
    public static final String EMPTY_STRING = "";
    private final PositiveNumber carSize;
    private final PositiveNumber movement;

    public RacingGame(int carSize, int movement) {
        this.carSize = new PositiveNumber(carSize);
        this.movement = new PositiveNumber(movement);
    }

    public String runAndResult(NumberCreator numberCreator) {
        Cars cars = createCars();
        StringBuilder movementStatusesResult = new StringBuilder();
        for (int index = 0; movement.isGreaterThan(index); index++) {
            cars.moveAll(numberCreator);
            movementStatusesResult.append(statusesResult(cars, index));
        }
        return movementStatusesResult.toString();
    }

    private Cars createCars() {
        List<Car> carList = new ArrayList<>();
        for (int index = 0; carSize.isGreaterThan(index); index++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }


    private String statusesResult(Cars cars, int index) {
        return movementStatuses(cars) +
                movementLineBreak(index);
    }

    private String movementLineBreak(int index) {
        int compareIndex = index + 1;
        if (movement.isGreaterThan(compareIndex)) {
            return LINE_BREAK;
        }
        return EMPTY_STRING;
    }

    private String movementStatuses(Cars cars) {
        List<String> currentStatuses = cars.currentStatuses();
        return String.join(LINE_BREAK, currentStatuses) + LINE_BREAK;
    }
}
