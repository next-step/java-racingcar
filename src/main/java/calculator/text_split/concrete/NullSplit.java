package calculator.text_split.concrete;

import calculator.text_split.InputText;
import calculator.text_split.handler.TextSplit;

import java.util.List;

public class NullSplit extends TextSplit {
    private static final List<String> EMPTY_TEXTS = List.of("0");

    public NullSplit(InputText text) {
        super(text);
    }

    @Override
    protected boolean resolve() {
        return text.input() == null;
    }

    @Override
    protected void done() {
        text.setTokens(EMPTY_TEXTS);
    }

}
