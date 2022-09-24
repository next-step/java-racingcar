package step2.parsed;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ParedStringByCustomDelimiter implements Parsed {

    private static final int CUSTOM_DELIMITER_INDEX = 2;

    private static final String INTRO_TO_BE_PARSED = "//.\n";

    private final String stringToBeParsed;

    public ParedStringByCustomDelimiter(String stringToBeParsed) {
        this.stringToBeParsed = stringToBeParsed;
    }

    @Override
    public List<String> parsedValue() {
        final String customDelimiter = customDelimiter();
        final String stringParsedIntro = stringParsedIntro();
        return Arrays.stream(stringParsedIntro.split(customDelimiter))
                .collect(toList());
    }

    private String customDelimiter() {
        return String.valueOf(stringToBeParsed.charAt(CUSTOM_DELIMITER_INDEX));
    }

    private String stringParsedIntro() {
        return stringToBeParsed.substring(INTRO_TO_BE_PARSED.length());
    }
}
