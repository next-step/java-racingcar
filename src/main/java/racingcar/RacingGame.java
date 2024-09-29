package racingcar;

import racingcar.exception.RacingGameException;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.NumberCreator;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final String LINE_BREAK = "\n";
    public static final String EMPTY_STRING = "";
    private final int carSize;
    private final int movement;

    public RacingGame(int carSize, int movement) {
        if (carSize < 1) {
            throw new RacingGameException("자동차는 최소 1대 이상이어야 합니다.");
        }
        if (movement < 1) {
            throw new RacingGameException("이동은 최소 1번 이상이어야 합니다.");
        }
        this.carSize = carSize;
        this.movement = movement;
    }

    public String runAndResult(NumberCreator numberCreator) {
        Cars cars = createCars();
        StringBuilder movementStatusesResult = new StringBuilder();
        for (int index = 0; index < movement; index++) {
            cars.moveAll(numberCreator);
            movementStatusesResult.append(statusesResult(cars, index));
        }
        return movementStatusesResult.toString();
    }

    private Cars createCars() {
        List<Car> carList = new ArrayList<>();
        for (int carIndex = 0; carIndex < carSize; carIndex++) {
            Car car = new Car();
            carList.add(car);
        }
        return new Cars(carList);
    }


    private String statusesResult(Cars cars, int index) {
        return movementStatuses(cars) +
                movementLineBreak(index);
    }

    private String movementLineBreak(int index) {
        int lastMovementIndex = movement - 1;
        if (index < lastMovementIndex) {
            return LINE_BREAK;
        }
        return EMPTY_STRING;
    }

    private String movementStatuses(Cars cars) {
        List<String> currentStatuses = cars.currentStatuses();
        return String.join(LINE_BREAK, currentStatuses) + LINE_BREAK;
    }
}
