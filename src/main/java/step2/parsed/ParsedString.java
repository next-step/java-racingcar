package step2.parsed;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class ParsedString implements Parsed {

    private static final Pattern NEGATIVE_JUDGMENT = Pattern.compile(".*-[0-9].*");

    private static final Pattern NUMBER_JUDGMENT = Pattern.compile(".*[0-9].*");

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private final String stringToBeParsed;

    public ParsedString(String stringToBeParsed) {
        this.stringToBeParsed = stringToBeParsed;
    }

    @Override
    public List<String> parsedValue() {
        verifyNegative();
        verifyNumber();
        return Arrays.stream(stringToBeParsed.split(DEFAULT_DELIMITER_REGEX))
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

}
