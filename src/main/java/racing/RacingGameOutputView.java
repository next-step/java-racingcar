package racing;

import java.util.List;

public class RacingGameOutputView {
    private static final String DASH = "-";

    public static void printOutputHeadMessage() {
        System.out.println(GameMessage.OUTPUT_HEAD_MESSAGE.getGameMessage());
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private static void printCarPosition(Car car) {
        int position = car.getPosition();
        System.out.println(convertIntegerToSymbol(position, DASH));
    }

    private static String convertIntegerToSymbol(int repeatCount, String symbol) {
        return symbol.repeat(repeatCount);
    }
}
