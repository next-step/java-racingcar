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
        List<String> entryList = gameResult.valueOfEntryList();
        initRound(entryList);
        for (int i = 0; i < gameResult.totalRound(); i++) {
            drawRound(entryList, gameResult.valueOfRoundResult(i));
        }

        announceWinners(gameResult.valueOfWinnerSet());
    }

    private static void initRound(List<String> entryList) {
        for (String carName : entryList) {
            drawPosition(carName, DEFAULT_POSITION);
        }
        System.out.println();
    }

    private static void announceWinners(Set<String> winnerSet) {
        StringBuilder winners = new StringBuilder();
        for (String winner : winnerSet) {
            winners.append(winner).append(SEPARATOR);
        }
        String winnersWithComma = winners.substring(0, winners.length() - 2);
        System.out.println(winnersWithComma + "가 최종 우승했습니다.");

    }

    private static void drawRound(List<String> entryList, List<Integer> roundResult) {
        for (int i = 0; i < roundResult.size(); i++) {
            drawPosition(entryList.get(i), roundResult.get(i));
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
