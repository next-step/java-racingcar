package calculator;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private final String operands;
    private final String delimiter;

    public StringSplitter(String operands, String delimiter) {
        validateNotBlank(operands, delimiter);
        this.operands = operands;
        this.delimiter = delimiter;
    }

    public void validateNotBlank(String operands, String delimiter) {
        if (isNullOrBlank(operands) || isNullOrBlank(delimiter)) {
            throw new IllegalArgumentException(
                    String.format("빈 입력값은 split 할 수 없다. operands: %s, delimiter: %s", operands, delimiter));
        }
    }

    private boolean isNullOrBlank(String value) {
        return value == null || value.isBlank();
    }

    public List<String> split() {
        return Arrays.asList(operands.split(delimiter));
    }
}
