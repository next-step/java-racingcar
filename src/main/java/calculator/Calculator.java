package calculator;

import java.util.Arrays;

public class Calculator {

    public static int sum(String text) {
        if (text.isBlank()) return 0;

        String[] values = text.split("[,|:]");
        return Arrays.stream(values).mapToInt(Integer::parseInt).sum();
    }

}
