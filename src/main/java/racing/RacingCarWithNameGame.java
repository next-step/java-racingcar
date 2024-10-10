package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarWithNameGame {

    public static void main(String[] args) {
        UserInput userInput = InputView.readInputWithName();

        System.out.println("실행 결과");
        start(userInput.getTotalCarNames(), userInput.getTotalRacingCounts());
    }

    public static void start(String totalCarNames, int totalRacingCounts) {

        RacingCars racingCars = new RacingCars(totalCarNames);

        for (int i = 0; i < totalRacingCounts; i++) {
            racingCars.racing();
            ResultView.display(racingCars.getPositions());
        }

        ResultView.displayWinners(racingCars.findWinners());
    }
}
