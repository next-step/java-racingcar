package racingcar.consoleview;

import java.util.List;
import racingcar.controller.extension.view.Viewable;
import racingcar.domain.response.RacingGamePlayResponse;
import racingcar.domain.response.RacingGamePlayResponse.RacingGameRoundResponse;

public class ConsoleView implements Viewable {

    private static final String DISTANCE_EXPRESSION = "-";
    private static final String NAME_SEPARATE_EXPRESSION = ", ";
    private static final String NAME_POSITION_SEPARATE_EXPRESSION = " : ";
    private static final int NAME_THRESHOLD = 2;

    private ConsoleView() {
    }

    public static ConsoleView getInstance() {
        return SingletonHelper.INSTANCE;
    }

    @Override
    public void draw(RacingGamePlayResponse racingGamePlayResponse) {
        System.out.println("실행 결과");
        racingGamePlayResponse.getRacingGameRoundResponses()
            .forEach(racingGameRoundResponse -> System.out.println(parseRoundResult(racingGameRoundResponse)));
        System.out.printf("%s가 최종 우승했습니다.", parseWinnerNames(racingGamePlayResponse.getWinnerNames()));
    }

    private String parseRoundResult(RacingGameRoundResponse racingGameRoundResponse) {
        StringBuilder stringBuilder = new StringBuilder();
        racingGameRoundResponse.getCarPerRoundResponses()
            .forEach(carPerRoundResponse -> stringBuilder
                .append(carPerRoundResponse.getName())
                .append(NAME_POSITION_SEPARATE_EXPRESSION)
                .append(buildPositionToString(carPerRoundResponse.getPosition()))
                .append("\n"));
        return stringBuilder.toString();
    }

    private String buildPositionToString(int position) {
        return DISTANCE_EXPRESSION.repeat(position);
    }

    private String parseWinnerNames(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder();
        winnerNames.forEach(winnerName -> stringBuilder.append(winnerName).append(NAME_SEPARATE_EXPRESSION));
        return stringBuilder.substring(0, stringBuilder.length() - NAME_THRESHOLD);
    }

    private static final class SingletonHelper {

        private static final ConsoleView INSTANCE = new ConsoleView();

    }

}
