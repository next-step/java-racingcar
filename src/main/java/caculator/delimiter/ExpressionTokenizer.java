package caculator.delimiter;

import caculator.model.ParsedText;

public class ExpressionTokenizer {

    public String[] tokenize(final ParsedText parsed) {
        return parsed.getExpression().split(
                parsed.getDelimiters().toRegex()
        );
    }

}
