package racinggame.ui;

import racinggame.car.Position;
import racinggame.game.Round;

import java.util.List;

public class ResultView {

    public static final String RESULT_PROMPT = "실행 결과";
    public static final String POSITION_GRAPH = "-";

    private ResultView() {
        throw new IllegalStateException("view class");
    }

    public static void promptGameResult(final List<Round> rounds) {
        System.out.println(RESULT_PROMPT);
        for (final var round : rounds) {
            promptRoundResult(round);
        }
    }

    public static void promptRoundResult(Round round) {
        for (final var position : round.result()) {
            System.out.println(getPositionGraph(position));
        }
        System.out.println();
    }

    private static String getPositionGraph(final Position position) {
        return POSITION_GRAPH.repeat(position.value());
    }

}
