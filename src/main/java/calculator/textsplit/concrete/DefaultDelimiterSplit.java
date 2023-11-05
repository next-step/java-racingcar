package calculator.textsplit.concrete;

import calculator.textsplit.InputText;
import calculator.textsplit.handler.TextSplit;

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
