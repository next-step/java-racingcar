package step2.StringCalculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {
    private final String rawInput;
    public Parser(String rawInput) {
        this.rawInput = rawInput;
    }

    public List<String> parse(String delimiter) {
        return Arrays.asList(rawInput.split(delimiter));
    }
}
