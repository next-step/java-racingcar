package step2.parsed;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParsedStringByDefaultDelimiter implements Parsed {

    private static final String EMPTY_STRING = "";

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private final String stringToBeParsed;

    public ParsedStringByDefaultDelimiter(String stringToBeParsed) {
        this.stringToBeParsed = stringToBeParsed;
    }

    @Override
    public List<String> parsedValue() {
        if (stringToBeParsed == null || stringToBeParsed.equals(EMPTY_STRING)) {
            return List.of("0");
        }

        return Arrays.stream(stringToBeParsed.split(DEFAULT_DELIMITER_REGEX))
                .collect(toList());
    }

}
