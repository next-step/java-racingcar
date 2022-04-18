package racingcar.view;

import racingcar.model.CarMoveDistance;
import racingcar.model.Identity;
import racingcar.model.PositiveNumber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private OutputView() {
    }

    private static final String RESULT_GUIDE = "실행 결과";
    private static final String COMMA_DELIMITER = ", ";
    private static final String COLON_DELIMITER = " : ";
    private static final String END_LINE = "\n";
    private static final String UNIT_DISTANCE = "-";
    private static final String WINNER_GUIDE = "가 최종 우승했습니다.";
    private static final StringBuilder racingResult = new StringBuilder();
    private static final StringBuilder winnerResult = new StringBuilder();


    public static void guide() {
        System.out.println(END_LINE + RESULT_GUIDE);
    }

    public static void racing(PositiveNumber trialStep, Map<Identity, CarMoveDistance> carMoveDistanceMap) {
        for (Identity identity : carMoveDistanceMap.keySet()) {
            PositiveNumber distanceEachStep = carMoveDistanceMap.get(identity)
                    .getMoveDistanceTrace()
                    .get(trialStep.getNumber());

            racingResult.append(identity.getIdentity())
                    .append(COLON_DELIMITER)
                    .append(UNIT_DISTANCE.repeat(distanceEachStep.getNumber()))
                    .append(END_LINE);
        }
        racingResult.append(END_LINE);
    }

    public static void winners(List<Identity> winners) {
        winnerResult.append(getWinners(winners))
                .append(WINNER_GUIDE);
    }

    public static void printRacingGameResult(List<Identity> winners) {
        winners(winners);
        System.out.println(racingResult.append(winnerResult));
    }

    private static String getWinners(List<Identity> winners) {
        return winners.stream().map(Identity::getIdentity).collect(Collectors.joining(COMMA_DELIMITER));
    }

}
