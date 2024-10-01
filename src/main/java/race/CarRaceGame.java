package race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CarRaceGame {
    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int roundCount = InputView.inputRoundCount();

        ResultView.print(play(roundCount, Car.create(carCount)));
    }

    private static List<CarRaceGameHistory> play(int roundCount, Car[] cars) {
        List<CarRaceGameHistory> histories = new ArrayList<>();

        for (int round = 1; round <= roundCount; round++) {
            Arrays.stream(cars).filter(car -> CarRaceGameRule.checkMove(new Random())).forEach(Car::move);
            histories.addAll(Arrays.asList(CarRaceGameHistory.record(round, cars)));
        }

        return histories;
    }
}
