package racing;

import java.util.List;

public class RacingPrinter {
    public static void drawPositions(List<Integer> CarsPosition) {
        for (Integer position : CarsPosition) {
            drawPosition(position);
        }
        System.out.println();
    }

    private static void drawPosition(Integer position) {
        StringBuilder symbol = new StringBuilder();
        for (int i = 0; i < position; i++) {
            symbol.append("-");
        }
        System.out.println(symbol);
    }
}
