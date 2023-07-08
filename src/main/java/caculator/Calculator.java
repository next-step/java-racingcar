package caculator;

import caculator.delimiter.DelimiterParser;
import caculator.delimiter.ExpressionTokenizer;
import caculator.model.Element;
import caculator.model.Elements;
import caculator.model.ParsedText;

public final class Calculator {

    private final DelimiterParser delimiterParser;
    private final ExpressionTokenizer tokenizer;

    public Calculator(final DelimiterParser delimiterParser, final ExpressionTokenizer tokenizer) {
        this.delimiterParser = delimiterParser;
        this.tokenizer = tokenizer;
    }

    public int sum(final String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        ParsedText parsedText = delimiterParser.parse(text);

        Elements elements = new Elements(
                tokenizer.tokenize(parsedText)
        );

        return elements.getElements().stream()
                       .mapToInt(Element::toInt)
                       .reduce(Integer::sum)
                       .orElseThrow(RuntimeException::new);
    }

}
