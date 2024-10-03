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

    public static int start(String totalCarNames, int totalRacingCounts) {
        int result = 0;

        RacingCar[] racingCars = readyRacingCars(totalCarNames);

        for (int i = 0; i < totalRacingCounts; i++) {
            result += racing(racingCars);
            ResultView.display(racingCars);
        }

        ResultView.displayWinners(findWinners(racingCars));
        return result;
    }

    private static RacingCar[] readyRacingCars(String totalCarNames) {
        String[] carNames = splitCarNames(totalCarNames);

        RacingCar[] racingCars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            racingCars[i] = new RacingCar(carNames[i], new Operator());
        }
        return racingCars;
    }

    private static String[] splitCarNames(String totalCarNames) {
        String[] carNames = totalCarNames.split(",");
        for (String carName : carNames) {
            validateCarName(carName);
        }
        return carNames;
    }

    private static void validateCarName(String carName) {
        if (carName != null && carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static int racing(RacingCar[] racingCars) {
        int result = 0;
        for (RacingCar racingCar : racingCars) {
            racingCar.race();
            result++;
        }
        return result;
    }

    public static List<RacingCar> findWinners(RacingCar[] racingCars) {
        int max = 0;
        for (RacingCar racingCar : racingCars) {
            max = Math.max(max, racingCar.getTotalForwardCounts());
        }

        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            winners.add(max == racingCar.getTotalForwardCounts() ? racingCar : null);
        }
        return winners.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }


}
