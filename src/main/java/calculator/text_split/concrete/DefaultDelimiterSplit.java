package calculator.text_split.concrete;

import calculator.text_split.InputText;
import calculator.text_split.handler.TextSplit;

public class DefaultDelimiterSplit extends TextSplit {
    private static final String DEFAULT_DELIMITER = ",|\\:";

    public DefaultDelimiterSplit(InputText text) {
        super(text);
    }

    @Override
    protected boolean resolve() {
        return true;
    }

    @Override
    protected void done() {
        text.split(DEFAULT_DELIMITER);
    }
}
