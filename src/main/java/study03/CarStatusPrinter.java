package study03;

import java.util.stream.IntStream;

/*
 *
 * CarStatusPrinter
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class CarStatusPrinter {

    private static final String SYMBOL = "-";

    public static void print(int position) {
        if (position == 0) {
            System.out.println("");
            return;
        }
        convertToSymbol(position);
    }

    private static void convertToSymbol(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, position)
                .forEach(x -> stringBuilder.append(SYMBOL));
        System.out.println(stringBuilder.toString());
    }
}
