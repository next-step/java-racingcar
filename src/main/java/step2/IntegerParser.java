package step2;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerParser implements Parser<Integer> {

    @Override
    public List<Integer> parse(List<String> elements) {
        return elements.stream()
                .filter(this::isNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isNumeric(String str) {
        return str.matches("^[0-9]+$");
    }
}
