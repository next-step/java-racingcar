package caculator;

import caculator.delimiter.DelimiterParser;
import caculator.model.Element;
import caculator.model.Elements;
import caculator.model.ParsedText;

public final class Calculator {

    private final DelimiterParser delimiterParser;

    public Calculator(final DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public int sum(final String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        ParsedText parsedText = delimiterParser.parse(text);

        Elements elements = new Elements(
                tokenize(parsedText)
        );

        return elements.getElements().stream()
                       .mapToInt(Element::toInt)
                       .reduce(Integer::sum)
                       .orElseThrow(RuntimeException::new);
    }

    private String[] tokenize(final ParsedText parsedText) {
        return parsedText.getExpression().split(
                parsedText.getDelimiters().toRegex()
        );
    }

}
