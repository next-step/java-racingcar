package caculator;

import caculator.delimiter.DelimiterParser;
import caculator.model.Element;
import caculator.model.Elements;
import caculator.model.ParsedText;

public final class Calculator {

    private Calculator() {
    }

    public static int sum(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        ParsedText parsedText = DelimiterParser.parse(text);

        Elements elements = new Elements(
                tokenize(parsedText)
        );

        return elements.getElements().stream()
                       .mapToInt(Element::toInt)
                       .reduce(Integer::sum)
                       .orElseThrow(RuntimeException::new);
    }

    private static String[] tokenize(ParsedText parsedText) {
        return parsedText.getExpression().split(
                parsedText.getDelimiters().toRegex()
        );
    }

}
