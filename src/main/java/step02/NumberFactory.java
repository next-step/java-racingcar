package step02;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum NumberFactory {

    POSITIVE(PositiveNumber::new),
    ZERO(Zero::new);

    private final Function<Integer, Number> numberFunction;

    NumberFactory(Function<Integer, Number> numberFunction) {
        this.numberFunction = numberFunction;
    }

    public static Number from(int number) {
        if (number > 0) {
            return POSITIVE.numberFunction.apply(number);
        }

        if (number == 0) {
            return ZERO.numberFunction.apply(number);
        }

        throw new IllegalArgumentException("음수 값을 포함하고 있습니다.");
    }

    public static List<Number> of(List<Integer> numbers) {
        return numbers.stream()
                .map(NumberFactory::from)
                .collect(Collectors.toList());
    }
}
