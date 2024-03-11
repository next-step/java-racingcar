package view;

import java.util.stream.Collectors;

import model.Name;
import model.RacingCar;
import model.RacingCars;
import model.Winners;

public class OutputView {

    private static final String MOVEMENT_INDICATOR = "-";
    private static final String STATUS_DELIMITER = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(final RacingCars racingCars) {
        for (final RacingCar racingCar : racingCars.getRacingCars()) {
            final String result = String.join(STATUS_DELIMITER, racingCar.getNameValue(),
                    MOVEMENT_INDICATOR.repeat(racingCar.getLocationValue()));
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(final Winners winners) {
        final String winnersName = winners.getNames()
                .stream()
                .map(Name::getName)
                .collect(Collectors.joining(WINNER_SEPARATOR));

        System.out.println(winnersName + "가 최종 우승했습니다.");
    }
}
