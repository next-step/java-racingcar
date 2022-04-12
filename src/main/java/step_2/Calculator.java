package step_2;

import java.util.List;
import java.util.function.Function;

public class Calculator {

    private final Splitter splitter;

    public Calculator(Splitter splitter) {
        this.splitter = splitter;
    }

    public int sum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        return splitter.split()
                .andThen(value -> new Numbers(value).getValues())
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