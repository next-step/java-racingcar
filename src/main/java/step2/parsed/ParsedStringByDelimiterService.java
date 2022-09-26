package step2.parsed;

import java.util.regex.Pattern;

public class ParsedStringByDelimiterService implements ParsedStringByDelimiterUseCase {

    private static final Pattern JUDGMENT_CUSTOM_DELIMITER = Pattern.compile("//(.)|\n(.*)");

    private final String stringToBeParsed;

    public ParsedStringByDelimiterService(String stringToBeParsed) {
        this.stringToBeParsed = stringToBeParsed;
    }

    @Override
    public Parsed parsedString() {
        if (stringToBeParsed == null) {
            return new ParsedStringByDefaultDelimiter(stringToBeParsed);
        }

        if (JUDGMENT_CUSTOM_DELIMITER.matcher(stringToBeParsed).find()) {
            return new ParsedStringByCustomDelimiter(stringToBeParsed);
        }

        return new ParsedStringByDefaultDelimiter(stringToBeParsed);
    }

}
