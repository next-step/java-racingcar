package step2.parsed;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class ParsedStringByCustomDelimiter implements Parsed {

    private static final int EMPTY_STRING_LENGTH = 0;

    private static final int CUSTOM_DELIMITER_INDEX = 2;

    private static final String INTRO_TO_BE_PARSED = "//.\n";

    private static final Pattern JUDGMENT_CORRECT_STRING = Pattern.compile("^(//.\n)");

    private final String stringToBeParsed;

    public ParsedStringByCustomDelimiter(String stringToBeParsed) {
        this.stringToBeParsed = stringToBeParsed;
    }

    @Override
    public List<String> parsedValue() {
        verifyPosition();

        final String stringParsedIntro = stringParsedIntro();
        if (stringParsedIntro.length() == EMPTY_STRING_LENGTH) {
            return List.of("0");
        }

        final String customDelimiter = customDelimiter();
        return Arrays.stream(stringParsedIntro.split(customDelimiter))
                .collect(toList());
    }

    private void verifyPosition() {
        if (!JUDGMENT_CORRECT_STRING.matcher(stringToBeParsed).find()) {
            throw new RuntimeException("유효한 문자열이 아닙니다.");
        }
    }

    private String customDelimiter() {
        return String.valueOf(stringToBeParsed.charAt(CUSTOM_DELIMITER_INDEX));
    }

    private String stringParsedIntro() {
        return stringToBeParsed.substring(INTRO_TO_BE_PARSED.length());
    }

}
