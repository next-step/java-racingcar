package calculator.text_split.concrete;

import calculator.text_split.InputText;
import calculator.text_split.handler.TextSplit;

import java.util.List;

public class EmptySplit extends TextSplit {
    public static final List<String> EMPTY_TEXTS = List.of("0");

    public EmptySplit(InputText text) {
        super(text);
    }

    @Override
    protected boolean resolve() {
        return text.input().isEmpty();
    }

    @Override
    protected void done() {
        text.setTokens(EMPTY_TEXTS);
    }
}
