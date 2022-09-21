package racingcar.util;

import java.util.function.Supplier;

public class InputIntegerRetry {

    private InputIntegerRetry() {
    }

    public static int retry(Supplier<String> inputView) {
        int result = Integer.parseInt(inputView.get());

        if (result < 0) {
            return retry(inputView);
        }

        return result;
    }
}
