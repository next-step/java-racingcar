package step_2;

import java.util.List;
import java.util.function.Function;

public class Calculator {

    private final Splitter splitter;
    private final NumberConverter numberConverter;

    public Calculator(Splitter splitter, NumberConverter numberConverter) {
        this.splitter = splitter;
        this.numberConverter = numberConverter;
    }

    public int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return splitter.split()
                .andThen(numberConverter.toInts())
                .andThen(this.sum())
                .apply(text);
    }

    private boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private Function<List<Integer>, Integer> sum() {
        return numbers -> numbers.stream().mapToInt(number -> number).sum();
    }
}