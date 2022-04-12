package calculator;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private final String operandsString;
    private final String delimiter;

    public StringSplitter(String operandsString, String delimiter) {
        this.operandsString = operandsString;
        this.delimiter = delimiter;
    }

    public List<String> split() {
        return Arrays.asList(operandsString.split(delimiter));
    }
}
