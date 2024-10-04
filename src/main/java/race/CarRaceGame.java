package race;

import java.util.ArrayList;
import java.util.List;

public class CarRaceGame {
    private static final int CAR_START_STEP = 0;
    private static final int CAR_MOVE_STEP = 1;
    
    private static final IRandomValueGenerator RANDOM_VALUE_GENERATOR = RandomValueGenerator.create();
    private static final ICarMoveRule CAR_MOVE_RULE = CarMoveRule.with(RANDOM_VALUE_GENERATOR);

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int roundCount = InputView.inputRoundCount();

        ResultView.print(play(roundCount, carCount));
    }

    private static List<CarRaceGameHistory> play(int roundCount, int carCount) {
        List<Car> cars = Car.create(CAR_START_STEP, carCount);
        List<CarRaceGameHistory> histories = new ArrayList<>();

        for (int round = 1; round <= roundCount; round++) {
            histories.addAll(playRound(round, cars));
        }

        return histories;
    }

    private static List<CarRaceGameHistory> playRound(int round, List<Car> cars) {
        List<CarRaceGameHistory> roundHistories = new ArrayList<>();

        cars.forEach(car -> {
            int step = car.moveBy(CAR_MOVE_RULE, CAR_MOVE_STEP);
            roundHistories.add(CarRaceGameHistory.record(round, step));
        });

        return roundHistories;
    }
}
