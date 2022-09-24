package step2.parsed;

import java.util.List;
import java.util.regex.Pattern;

public class ParsedString implements Parsed {

    private static final Pattern NEGATIVE_JUDGMENT = Pattern.compile(".*-[0-9].*");

    private final String stringToBeParsed;

    public ParsedString(String stringToBeParsed) {
        this.stringToBeParsed = stringToBeParsed;
    }

    @Override
    public List<String> parsedValue() {
        verifyNegative();
        return null;
    }

    private void verifyNegative() {
        if (NEGATIVE_JUDGMENT.matcher(stringToBeParsed).find()) {
            throw new RuntimeException("음수를 입력할 수 없습니다.");
        }
    }
}
