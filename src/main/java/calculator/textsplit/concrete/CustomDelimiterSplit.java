package calculator.textsplit.concrete;

import calculator.textsplit.InputText;
import calculator.textsplit.handler.TextSplit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterSplit extends TextSplit {
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    private String customDelimiter;
    private String customText;

    public CustomDelimiterSplit(InputText text) {
        super(text);
    }

    @Override
    protected boolean resolve() {
        return isCustom();
    }

    @Override
    protected void done() {
        changeCustom();
        text.split(customText, customDelimiter);
    }

    private boolean isCustom() {
        Matcher m = CUSTOM_PATTERN.matcher(text.input());
        return m.find();
    }

    private void changeCustom() {
        Matcher m = CUSTOM_PATTERN.matcher(text.input());
        if (m.find()) {
            customDelimiter = m.group(1);
            customText = m.group(2);
        }
    }
}
