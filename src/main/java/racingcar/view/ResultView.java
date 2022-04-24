package racingcar.view;

import racingcar.dto.RoundResult;
import racingcar.model.CarName;
import racingcar.model.Distance;

import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {
    private static final String START_TEXT = "실행 결과";
    private static final String ROUND_CAR_NAME_DELIMITER = " : ";
    private static final String CAR_STATE = "-";
    private static final String EMPTY = "";
    private static final String WINNER_NAME_DELIMITER = ",";
    private static final String WIN_RESULT_TEXT = "가 최종 우승했습니다.";

    private ResultView() {
        throw new AssertionError();
    }

    public static void print(List<RoundResult> roundResults) {
        printStartText();
        for (RoundResult roundResult : roundResults) {
            printRoundResult(roundResult.getCarsCount(), roundResult.getCarNames(), roundResult.getDistances());
        }
    }

    private static void printStartText() {
        System.out.println(START_TEXT);
    }

    private static void printRoundResult(int carsCount, List<CarName> carNames, List<Distance> states) {
        for (int i = 0; i < carsCount; i++) {
            printCarInfo(carNames.get(i), states.get(i));
        }
        System.out.println(EMPTY);
    }

    private static void printCarInfo(CarName carName, Distance state) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName.value() + ROUND_CAR_NAME_DELIMITER);
        for (int j = 0; j < state.value(); j++) {
            sb.append(CAR_STATE);
        }
        System.out.println(sb);
    }

    public static void printWinner(List<CarName> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(WINNER_NAME_DELIMITER, getCarName(winners)));
        sb.append(WIN_RESULT_TEXT);
        System.out.println(sb);
    }

    private static List<String> getCarName(List<CarName> winners) {
        return winners.stream()
                .map(winner -> winner.value())
                .collect(Collectors.toList());
    }
}
