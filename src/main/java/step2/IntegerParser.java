package step2;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IntegerParser implements Parser<Integer> {

    private static final Pattern numericPattern = Pattern.compile("^[0-9]+$");

    @Override
    public List<Integer> parse(List<String> elements) {
        return elements.stream()
                .filter(this::isNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isNumeric(String str) {
        return numericPattern.matcher(str).matches();
    }
}
