package racingcar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class InputViewUtil {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    private InputViewUtil() {
    }

    public static String input(String inputMessage) {
        System.out.print(inputMessage);

        try {
            return BR.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int inputPositiveInt(Supplier<String> inputView) {
        int number = Integer.parseInt(inputView.get());

        if (number < 0) {
            return inputPositiveInt(inputView);
        }

        return number;
    }
}
