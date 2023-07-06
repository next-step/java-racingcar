package racingcar.app.view;

import java.util.List;
import racingcar.controller.response.RacingGamePlayControllerResponse;
import racingcar.controller.response.RacingGamePlayControllerResponse.RacingGamePlayControllerRoundResponse;

public class ConsoleView {

    private static final String DISTANCE_EXPRESSION = "-";
    private static final int NAME_THRESHOLD = 2;

    private final StringBuffer stringBuffer = new StringBuffer();

    public void printResult(RacingGamePlayControllerResponse response) {
        System.out.println("실행 결과");
        response.getRacingGameRoundResponses()
            .forEach(r -> System.out.println(parseRoundResult(r)));
        System.out.printf("%s가 최종 우승했습니다.", parseWinnerNames(response.getWinnerNames()));
    }

    private String parseRoundResult(RacingGamePlayControllerRoundResponse racingGamePlayControllerRoundResponse) {
        stringBuffer.setLength(0);
        racingGamePlayControllerRoundResponse.getCarPerRoundResponses()
            .forEach(c -> stringBuffer
                .append(c.getName())
                .append(" : ")
                .append(buildPositionToString(c.getPosition()))
                .append("\n"));
        return stringBuffer.toString();
    }

    private String buildPositionToString(int position) {
        return DISTANCE_EXPRESSION.repeat(position);
    }

    private String parseWinnerNames(List<String> winnerNames) {
        stringBuffer.setLength(0);
        winnerNames.forEach(w -> stringBuffer.append(w).append(", "));
        return stringBuffer.substring(0, stringBuffer.length() - NAME_THRESHOLD);
    }

}
