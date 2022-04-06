package step02;

import java.util.List;
import java.util.stream.Collectors;

public final class NumberConverter {

    public List<Integer> convertToNumber(List<String> stringNumbers) {
        return stringNumbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}
