package calculator.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.number.PositiveOrZero.ZERO;

public class PositiveOrZeros {

    private final List<PositiveOrZero> positiveOrZeros;

    public PositiveOrZeros(String[] strings) {
        this(convertToList(strings));
    }

    public PositiveOrZeros(List<PositiveOrZero> positiveOrZeros) {
        this.positiveOrZeros = positiveOrZeros;
    }

    private static List<PositiveOrZero> convertToList(String[] strings) {
        return Arrays.stream(strings)
                .map(PositiveOrZero::new)
                .collect(Collectors.toList());
    }

    public PositiveOrZero addAll() {
        return this.positiveOrZeros
                .stream()
                .reduce(ZERO, PositiveOrZero::add);
    }

}
