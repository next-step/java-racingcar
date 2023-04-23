package racing;

import java.util.List;
import java.util.Set;
import racing.domain.GameResult;

public class RacingPrinter {

    public static final String POSITION_SYMBOL = "-";
    public static final int DEFAULT_POSITION = 1;
    public static final String SEPARATOR = ", ";
    public static final String DELIMITER = " : ";

    public static void drawResult(GameResult gameResult) {
        List<String> entries = gameResult.valueOfEntryList();
        initRound(entries);
        for (int i = 0; i < gameResult.totalRound(); i++) {
            drawRound(entries, gameResult.valueOfRoundResult(i));
        }

        announceWinners(gameResult.valueOfWinnerSet());
    }

    private static void initRound(List<String> entries) {
        for (String carName : entries) {
            drawPosition(carName, DEFAULT_POSITION);
        }
        System.out.println();
    }

    private static void announceWinners(Set<String> winners) {
        System.out.println(winners.toString() + "가 최종 우승했습니다.");

    }

    private static void drawRound(List<String> entries, List<Integer> roundResult) {
        for (int i = 0; i < roundResult.size(); i++) {
            drawPosition(entries.get(i), roundResult.get(i));
        }
        System.out.println();
    }

    private static void drawPosition(String carName, Integer position) {
        StringBuilder symbol = new StringBuilder();
        for (int i = 0; i < position; i++) {
            symbol.append(POSITION_SYMBOL);
        }
        System.out.println(carName + DELIMITER + symbol);

    }
}
