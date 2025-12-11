package step5.racing.view;

import java.util.ArrayList;
import java.util.List;
import step5.racing.domain.CarName;
import step5.racing.domain.CarResult;
import step5.racing.domain.RaceResult;
import step5.racing.domain.RoundResult;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_RESULT_FORMAT = "%s : %s";
    private static final String POSITION_MARK = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String WINNER_RESULT_FORMAT = "가 최종 우승했습니다.";

    public static void printRaceResult(RaceResult raceResult) {
        System.out.println(RACE_RESULT_MESSAGE);

        for (RoundResult roundResult : raceResult.getRaceResult()) {
            printRoundResult(roundResult);
        }
        printWinners(raceResult);
    }

    private static void printRoundResult(RoundResult roundResult) {
        for (CarResult carResult : roundResult.getRoundResult()) {
            System.out.println(carResultFormat(carResult));
        }
        printNewLine();
    }

    private static String carResultFormat(CarResult carResult) {
        String name = carResult.name().value();
        String position = POSITION_MARK.repeat(carResult.position().value());
        return String.format(CAR_RESULT_FORMAT, name, position);
    }

    private static void printWinners(RaceResult raceResult) {
        String winnersFormat = winnersFormat(raceResult.winners());
        System.out.println(winnersFormat + WINNER_RESULT_FORMAT);
    }

    private static String winnersFormat(List<CarName> winners) {
        List<String> names = new ArrayList<>();

        for (CarName carName : winners) {
            names.add(carName.value());
        }
        return String.join(WINNER_NAME_DELIMITER, names);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
