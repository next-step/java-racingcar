package race;

import java.util.ArrayList;
import java.util.List;

public class CarRaceGame {
    private static final int CAR_START_STEP = 0;
    private static final CarMoveRule CAR_MOVE_RULE = CarRandomMoveRule.create();

    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int roundCount = InputView.inputRoundCount();

        ResultView.print(play(roundCount, carNames));
    }

    private static List<CarRaceGameHistory> play(int roundCount, List<String> names) {
        List<Car> cars = Car.create(CAR_START_STEP, names);
        List<CarRaceGameHistory> histories = new ArrayList<>();

        for (int round = 1; round <= roundCount; round++) {
            histories.addAll(playRound(round, cars));
        }

        return histories;
    }

    private static List<CarRaceGameHistory> playRound(int round, List<Car> cars) {
        List<CarRaceGameHistory> roundHistories = new ArrayList<>();

        cars.forEach(car -> {
            CarMoveRuleValue carMoveRuleValue = CarRandomMoveRuleValue.create(CarRandomMoveRule.BOUND_OF_RANDOM);
            car.moveBy(CAR_MOVE_RULE, carMoveRuleValue);
            roundHistories.add(car.recordHistory(round));
        });

        return roundHistories;
    }
}
