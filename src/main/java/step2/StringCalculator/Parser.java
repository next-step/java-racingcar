package step2.StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Parser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//.+\\\\n");
    private static final String DEFAULT_DELIMITER = "\\:|\\,";
    private static final String CUSTOM_PARSER_END_STRING = "\\n";
    private static final String EMPTY_STRING = "";
    private static final int CUSTOM_PARSER_STARTING_INDEX = 2;

    private final Matcher matcher;
    private final String rawInput;
    private final String delimiter;

    public Parser(String rawInput) {
        this.matcher = CUSTOM_DELIMITER_PATTERN.matcher(rawInput);
        this.rawInput = rawInput;
        this.delimiter = getDelimiter();
    }

    public List<Integer> parse() {
        String parsedInput = getInputString();

        if (parsedInput.equals(EMPTY_STRING)) {
            return Collections.EMPTY_LIST;
        }

        return parseInteger(Arrays.asList(parsedInput.split(delimiter)));
    }

    private List<Integer> parseInteger(List<String> parsedInput) {
        return parsedInput.stream()
                   .map(Integer::valueOf)
                   .collect(Collectors.toList());
    }

    private String getInputString() {
        if (matcher.find(0)) {
            return matcher.replaceAll(EMPTY_STRING);
        }
        return rawInput;
    }

    private String getDelimiter() {
        if (matcher.find(0)) {
            return rawInput.substring(CUSTOM_PARSER_STARTING_INDEX, rawInput.indexOf(CUSTOM_PARSER_END_STRING));
        }
        return DEFAULT_DELIMITER;
    }
}
