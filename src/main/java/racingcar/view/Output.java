package racingcar.view;

import racingcar.domain.ResultCar;
import racingcar.domain.ResultRound;
import racingcar.domain.ResultWinners;

import java.util.List;

public class Output {
    private static final String WINNER_MSG = "최종 우승자: ";
    private static final String WINNER_DELIMITER = ",";
    private static final String ROUND_START_MSG = "실행 결과";
    private static final String CAR_DELIMITER = " : ";
    private static final String CAR_LOCATION_SIGN = "-";

    public void printWinners(ResultWinners result) {
        List<String> winners = result.getWinners();
        System.out.println(WINNER_MSG + String.join(WINNER_DELIMITER, winners));
    }

    public void printRoundStart() {
        System.out.println(ROUND_START_MSG);
    }

    public void printRound(ResultRound result) {
        for(ResultCar resultCar : result.getResultCars()) {
            printResultCar(resultCar);
        }
        System.out.println();
    }

    private void printResultCar(ResultCar result) {
        StringBuilder formattedLocation = new StringBuilder();
        for (int i = 0; i < result.getLocation(); i++) {
            formattedLocation.append(CAR_LOCATION_SIGN);
        }

        System.out.println(
            result.getCarName() + CAR_DELIMITER + formattedLocation.toString()
        );
    }
}
