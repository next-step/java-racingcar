package racing;

public class OutputView {
    private static final String OUTPUT_HEAD_MESSAGE = "\n실행결과";
    private static final String DASH = "-";

    public static void printCarPosition(Car testCar) {
        System.out.println(OUTPUT_HEAD_MESSAGE);

        int position = testCar.getPosition();
        System.out.println(convertIntegerToSymbol(position, DASH));
    }

    private static String convertIntegerToSymbol(int repeatCount, String symbol) {
        return symbol.repeat(repeatCount);
    }
}
