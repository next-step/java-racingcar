package racing;

public class RacingGameOutputView {
    private static final String DASH = "-";

    public static void printCarPosition(Car testCar) {
        System.out.println(GameMessage.OUTPUT_HEAD_MESSAGE.getGameMessage());

        int position = testCar.getPosition();
        System.out.println(convertIntegerToSymbol(position, DASH));
    }

    private static String convertIntegerToSymbol(int repeatCount, String symbol) {
        return symbol.repeat(repeatCount);
    }
}
