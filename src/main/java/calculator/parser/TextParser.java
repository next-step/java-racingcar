package calculator.parser;

import calculator.model.NonNegativeNumbers;
import calculator.util.TextSplitter;
import java.util.List;

public final class TextParser {

    private static class DelimiterResolverHolder {
        private static final TextParser INSTANCE = new TextParser();
    }

    private TextParser() {
    }

    public static TextParser getInstance() {
        return DelimiterResolverHolder.INSTANCE;
    }

    public NonNegativeNumbers parse(final String text) {
        final List<String> nums = TextSplitter.split(text);
        return NonNegativeNumbers.of(nums);
    }
}
