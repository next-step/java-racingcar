package racinggame.ui;

import racinggame.car.Car;
import racinggame.car.Position;
import racinggame.game.Round;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_PROMPT = "실행 결과";
    private static final String POSITION_GRAPH = "-";
    private static final String WINNER_PROMPT = "(이)가 최종 우승했습니다.";

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
        for (final var entry : round.result().entrySet()) {
            final var name = entry.getKey().name();
            final var position = entry.getValue();
            System.out.println(name + " : " + getPositionGraph(position));
        }
        System.out.println();
    }

    private static String getPositionGraph(final Position position) {
        return POSITION_GRAPH.repeat(position.value());
    }

    public static void promptWinners(List<Car> winners) {
        final var names = winners.stream()
                .map(winner -> winner.name().value())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", names) + WINNER_PROMPT);
    }

}
