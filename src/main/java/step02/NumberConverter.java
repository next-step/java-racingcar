package step02;

import java.util.List;
import java.util.stream.Collectors;

public final class NumberConverter {

    public List<Number> convertToNumber(List<String> stringNumbers) {
        return stringNumbers.stream()
                .map(stringNumber -> NumberFactory.from(Integer.parseInt(stringNumber)))
                .collect(Collectors.toList());
    }

}
