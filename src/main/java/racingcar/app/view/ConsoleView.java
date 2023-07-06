package racingcar.app.view;

import java.util.List;
import racingcar.domain.response.RacingGamePlayResponse;
import racingcar.domain.response.RacingGamePlayResponse.RacingGameRoundResponse;

public class ConsoleView {

    private static final String DISTANCE_EXPRESSION = "-";
    private static final String NAME_SEPERATE_EXPRESSION = ", ";
    private static final String NAME_POSITION_SEPERATE_EXPRESSION = " : ";
    private static final int NAME_THRESHOLD = 2;

    public void printResult(RacingGamePlayResponse response) {
        System.out.println("실행 결과");
        response.getRacingGameRoundResponses()
            .forEach(racingGameRoundResponse -> System.out.println(parseRoundResult(racingGameRoundResponse)));
        System.out.printf("%s가 최종 우승했습니다.", parseWinnerNames(response.getWinnerNames()));
    }

    private String parseRoundResult(RacingGameRoundResponse racingGameRoundResponse) {
        StringBuilder stringBuilder = new StringBuilder();
        racingGameRoundResponse.getCarPerRoundResponses()
            .forEach(c -> stringBuilder
                .append(c.getName())
                .append(NAME_POSITION_SEPERATE_EXPRESSION)
                .append(buildPositionToString(c.getPosition()))
                .append("\n"));
        return stringBuilder.toString();
    }

    private String buildPositionToString(int position) {
        return DISTANCE_EXPRESSION.repeat(position);
    }

    private String parseWinnerNames(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        winnerNames.forEach(w -> stringBuilder.append(w).append(NAME_SEPERATE_EXPRESSION));
        return stringBuilder.substring(0, stringBuilder.length() - NAME_THRESHOLD);
    }

}
