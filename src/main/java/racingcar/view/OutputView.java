package racingcar.view;

import racingcar.domain.RacingScoreCard;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String TEXT_TITLE = "\n실행결과";
    private static final String TEXT_WINNER ="가 최종 우승했습니다.";
    private static final String TEXT_SEPARATOR_BETWEEN_NAMES = ", ";
    private OutputView() {

    }

    public static void printTitle() {
        System.out.println(TEXT_TITLE);
    }

    public static void printRaceResultByTime(List<RacingScoreCard> raceResults) {
        for (RacingScoreCard result : raceResults) {
            draw(result.getName(), result.getPosition());
        }
        System.out.println();
    }

    private static void draw(String name, int position) {
        System.out.print(name + " : ");
        for (int i = 0 ; i < position ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinner(List<RacingScoreCard> winner) {
        String winnerName = winner.stream()
                .map(RacingScoreCard::getName)
                .collect(Collectors.joining(TEXT_SEPARATOR_BETWEEN_NAMES));
        System.out.println(winnerName + TEXT_WINNER);
    }

}
