package racing.view;

import racing.domain.RacingCar.Name;
import racing.util.Delimiter;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String WINNER_PRESENTATION = "가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printMessage(String dialogue) {
        System.out.println(dialogue);
    }

    public static void printResult(List<Name> winners) {
        String result = winners.stream().map(Name::toString).collect(Collectors.joining(Delimiter.COMMA.symbol));
        printMessage(String.format("%s%S", result, WINNER_PRESENTATION));
    }
}
