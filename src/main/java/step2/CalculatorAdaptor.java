package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step2.SeparatorUtils.getSeparator;
import static step2.SeparatorUtils.removePrefixSeparator;

public class CalculatorAdaptor {
    private static final int defaultValue = 0;
    private final String origin;
    private final List<Integer> parsed;

    public CalculatorAdaptor(String origin) {
        this.origin = origin;

        if (SeparatorUtils.isNullOrEmpty(origin)) {
            this.parsed = Arrays.asList(defaultValue);
            return;
        }

        this.parsed = Arrays.stream(removePrefixSeparator(origin).split(getSeparator(origin)))
                .map(PositiveParser::new)
                .map(PositiveParser::parse)
                .collect(Collectors.toList());
    }

    public int[] adapt() {
        return parsed.stream().mapToInt(Integer::intValue).toArray();
    }
}
