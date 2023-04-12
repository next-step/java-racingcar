package racing;

import java.util.List;

public class RacingPrinter {

    public static final String POSITION_SYMBOL = "-";

    public static void drawPositions(List<Integer> CarsPosition) {
        for (Integer position : CarsPosition) {
            drawPosition(position);
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
