package step3.view;

import step3.domain.RacingCar;
import step3.domain.RacingCars;

import java.util.Collections;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_TITLE = "==============";
    private static final String WINNER_NAME_DELIMITER = ",";

    private static final String POSITION_INDICATOR = "-";
    private static final String POSITION_DELEMETER = "";

    private ResultView() {
    }

    public static void printPosition(RacingCars racingCars) {
        System.out.println(RESULT_TITLE);
        racingCars.getAll().stream()
                .map(racingCar -> {
                    String racingCarName = racingCar.getName();
                    String currentPosition = String.join(POSITION_DELEMETER, Collections.nCopies(racingCar.getPosition(), POSITION_INDICATOR));

                    return racingCarName + " : " + currentPosition;
                })
                .forEach(System.out::println);
    }

    public static void printWinner(RacingCars racingCars) {
        System.out.println(racingCars.getWinners().stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER)) + "가 최종 우승했습니다.");
    }
}
