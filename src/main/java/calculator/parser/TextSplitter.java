package calculator.parser;

import java.util.List;

public final class TextSplitter {

    public static final String BASIC_DELIMITER = ",|:";

    private final List<String> values;

    public TextSplitter(final String text) {
        this(text, BASIC_DELIMITER);
    }

    public TextSplitter(final String text, final String delimiter) {
        this.values = List.of(
                text.split(delimiter)
        );
    }

    public List<String> getValues() {
        return this.values;
    }

    @Override
    public String toString() {
        return "TextSplitter{" + "values :: " + values + '}';
    }

}
