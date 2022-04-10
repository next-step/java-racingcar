package step_2;

import java.util.List;
import java.util.function.Function;

public class Calculator {

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return Splitter.split()
                .andThen(NumberConverter.toInts())
                .andThen(sum())
                .apply(text);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static Function<List<Integer>, Integer> sum() {
        return numbers -> numbers.stream().mapToInt(number -> number).sum();
    }
}