package calculator.textsplit.concrete;

import calculator.textsplit.InputText;
import calculator.textsplit.handler.TextSplit;

public class NoSplit extends TextSplit {
    public NoSplit(InputText text) {
        super(text);
    }

    @Override
    protected boolean resolve() {
        return false;
    }

    @Override
    protected void done() {
    }
}
