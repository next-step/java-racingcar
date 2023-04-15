package racing;

import racing.domain.GameResult;
import racing.domain.RoundResult;

public class RacingPrinter {

    public static final String POSITION_SYMBOL = "-";

    public static void drawPositions(GameResult gameResult) {
        for (int i = 0; i < gameResult.totalRound(); i++) {
            drawRound(gameResult.valueOfRoundResult(i));
        }
    }

    private static void drawRound(RoundResult round) {
        for (int i = 0; i < round.totalResult(); i++) {
            drawPosition(round.valueOfCarPosition(i));
        }
        System.out.println();
    }

    private static void drawPosition(Integer position) {
        StringBuilder symbol = new StringBuilder();
        for (int i = 0; i < position; i++) {
            symbol.append(POSITION_SYMBOL);
        }
        System.out.println(symbol);
    }
}
