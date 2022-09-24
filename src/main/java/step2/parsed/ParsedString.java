package step2.parsed;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class ParsedString implements Parsed {

    private static final Pattern NEGATIVE_JUDGMENT = Pattern.compile(".*-[0-9].*");

    private static final Pattern NUMBER_JUDGMENT = Pattern.compile(".*[0-9].*");

    private static final Pattern CUSTOM_DELIMITER_JUDGMENT = Pattern.compile("^(//.\\n)");

    private final String stringToBeParsed;

    public ParsedString(String stringToBeParsed) {
        this.stringToBeParsed = stringToBeParsed;
    }

    @Override
    public List<String> parsedValue() {
        verifyNegative();
        verifyNumber();

        if (CUSTOM_DELIMITER_JUDGMENT.matcher(stringToBeParsed).find()) {
            final String customDelimiter = customDelimiter();
            final String stringParsedIntro = stringParsedIntro();
            return Arrays.stream(stringParsedIntro.split(customDelimiter))
                    .collect(toList());
        }

        final String defaultDelimiterRegex = "[,:]";
        return Arrays.stream(stringToBeParsed.split(defaultDelimiterRegex))
                .collect(toList());
    }

    private void verifyNegative() {
        if (NEGATIVE_JUDGMENT.matcher(stringToBeParsed).find()) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }

    private void verifyNumber() {
        if (!NUMBER_JUDGMENT.matcher(stringToBeParsed).find()) {
            throw new RuntimeException("숫자 이외의 문자를 입력할 수 없습니다.");
        }
    }

    private String customDelimiter() {
        final int customDelimiterIndex = 2;
        return String.valueOf(stringToBeParsed.charAt(customDelimiterIndex));
    }

    private String stringParsedIntro() {
        final String introToBeParsed = "//.\n";
        final int introLength = introToBeParsed.length();
        return stringToBeParsed.substring(introLength);
    }

}
