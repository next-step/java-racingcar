package racinggame.view;

import java.util.HashMap;
import java.util.Map;
import racinggame.Utils;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;
import racinggame.domain.vo.WinnersVo;

public class GameView {

    private static final String DELIMITER = ", ";
    private static final String FOOTPRINTS = "-";

    protected static final StringBuilder result = new StringBuilder();
    private static final Map<String, String> resultOfCar = new HashMap<>();
    private static final Map<String, Integer> positionOfCar = new HashMap<>();

    private GameView() {
    }

    public static void init(RacingCars racingCars) {
        racingCars.get().stream()
                .forEach(car -> {
                    String carName = car.getName();
                    resultOfCar.put(carName, String.format("%-5s: %s", carName,
                            Utils.repeat(FOOTPRINTS, car.getPosition())));
                    positionOfCar.put(carName, 0);
                });
    }

    public static void saveProgress(RacingCars racingCars) {
        racingCars.get().forEach(car -> result.append(drawCurrResult(car)).append("\n"));
    }

    private static String drawCurrResult(RacingCar racingCar) {
        String carName = racingCar.getName();
        return resultOfCar.put(carName, resultOfCar.get(carName)
                + Utils.repeat(FOOTPRINTS, countForward(racingCar)));
    }

    private static int countForward(RacingCar racingCar) {
        int currPosition = racingCar.getPosition();
        String carName = racingCar.getName();

        int steps = currPosition - positionOfCar.get(carName);
        positionOfCar.put(carName, currPosition);

        return steps;
    }

    public static void printWinners(final WinnersVo winners) {
        final String result = String.join(DELIMITER, winners.get());
        System.out.println("최종 우승자: " + result);
    }

    public static void printResult() {
        System.out.print(result);
    }
}
