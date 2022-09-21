package racingcar.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class InputViewUtil {
    private InputViewUtil() {
    }

    public static int inputPositiveInt(Supplier<String> inputView) {
        int number = Integer.parseInt(inputView.get());

        if (number < 0) {
            return inputPositiveInt(inputView);
        }

        return number;
    }
}
