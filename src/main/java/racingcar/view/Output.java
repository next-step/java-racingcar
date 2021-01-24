package racingcar.view;

import racingcar.domain.ResultWinners;

import java.util.List;

public class Output {
    private static final String WINNER_MSG = "최종 우승자: ";
    private static final String WINNER_DELIMITER = ",";

    public void printWinners(ResultWinners result) {
        List<String> winners = result.getWinners();
        System.out.println(WINNER_MSG + String.join(WINNER_DELIMITER, winners));
    }
}
