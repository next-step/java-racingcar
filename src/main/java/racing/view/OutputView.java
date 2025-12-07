package racing.view;

import racing.domain.CarResult;
import racing.domain.RaceResult;
import racing.domain.RoundResult;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String POSITION_MARK = "-";

    public static void printRaceResult(RaceResult raceResult) {
        System.out.println(RACE_RESULT_MESSAGE);

        for (RoundResult roundResult : raceResult.getRaceResult()) {
            printRoundResult(roundResult);
        }
    }

    private static void printRoundResult(RoundResult roundResult) {
        for (CarResult carResult : roundResult.getRoundResult()) {
            System.out.println(carResultFormat(carResult));
        }
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static String carResultFormat(CarResult carResult) {
        String carName = carResult.getCarName().value();
        String position = POSITION_MARK.repeat(carResult.getPosition().value());
        return String.format(CAR_RESULT_FORMAT, carName, position);
    }
}
