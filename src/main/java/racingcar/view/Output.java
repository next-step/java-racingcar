package racingcar.view;

import racingcar.domain.ResultCar;
import racingcar.domain.ResultRound;
import racingcar.domain.ResultWinners;

import java.util.List;

public class Output {
    private static final String WINNER_MSG = "최종 우승자: ";
    private static final String WINNER_DELIMITER = ",";
    private static final String ROUND_MSG = "실행 결과";
    private static final String CAR_DELIMITER = " : ";

    public void printWinners(ResultWinners result) {
        List<String> winners = result.getWinners();
        System.out.println(WINNER_MSG + String.join(WINNER_DELIMITER, winners));
    }

    public void printRound(ResultRound result) {
        System.out.println(ROUND_MSG);
        for(ResultCar resultCar : result.getResultCars()) {
            printResultCar(resultCar);
        }
    }

    private void printResultCar(ResultCar result) {
        System.out.println(
            result.getCar() + CAR_DELIMITER + result.getLocation()
        );
    }
}
