package caculator.delimiter;

import caculator.model.ParsedText;

public class ExpressionTokenizer {

    public String[] tokenize(ParsedText parsed) {
        return parsed.getExpression().split(
                parsed.getDelimiters().toRegex()
        );
    }

}
