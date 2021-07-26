package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RaceHistory;
import racingcar.view.InputView;

public class RacingCarController {

    public static final String POSITIVE_EXCEPTION = "입력값이 양수이어야 합니다.";

    private final int numberOfRounds;
    private Cars cars;

    private RacingCarController(int numberOfCars, int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
        cars = Cars.createWithDefaults(numberOfCars);
    }

    public static RacingCarController createFromUserInput() {
        int[] inputs = userInput();
        int numberOfCars = inputs[0];
        int numberOfRounds = inputs[1];
        return new RacingCarController(numberOfCars, numberOfRounds);
    }

    private static int[] userInput() {
        int numberOfCars = InputView.askForNumberOfCars();
        int numberOfRounds = InputView.askForNumberOfRounds();
        validate(numberOfCars);
        validate(numberOfRounds);
        return new int[]{numberOfCars, numberOfRounds};
    }

    private static void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(POSITIVE_EXCEPTION);
        }
    }

    public RaceHistory run(MoveStrategy moveStrategy) {
        RaceHistory raceHistory = new RaceHistory();
        for (int i = 0; i < numberOfRounds; i++) {
            cars = cars.move(moveStrategy);
            raceHistory.update(cars);
        }
        return raceHistory;
    }
}
