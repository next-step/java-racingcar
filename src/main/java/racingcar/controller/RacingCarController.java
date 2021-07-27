package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RaceHistory;
import racingcar.view.InputView;

public class RacingCarController {

    public static final String POSITIVE_EXCEPTION = "입력값이 양수이어야 합니다.";
    public static final String COMMA = ",";

    private final int numberOfRounds;
    private Cars cars;

    private RacingCarController(List<String> names, int numberOfRounds) {
        validate(numberOfRounds);
        this.numberOfRounds = numberOfRounds;
        cars = Cars.createWithNames(names);
    }

    public static RacingCarController createFromUserInput() {
        List<String> names = namesFromUserInput();
        int numberOfRounds = InputView.askForNumberOfRounds();
        return new RacingCarController(names, numberOfRounds);
    }

    private static List<String> namesFromUserInput() {
        String text = InputView.askForCarNames();
        return Arrays.asList(text.split(COMMA));
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
