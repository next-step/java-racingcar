package lotto;

import java.util.Arrays;

public class CustomSplitter {
    private static final int CUSTOM_SPLITTER_INDEX = 4;
    private static final int CUSTOM_SPLITTER_START_INDEX = 2;
    private static final int CUSTOM_SPLITTER_END_INDEX = 3;
    private static final String CUSTOM_SPLITTER_BEGIN_TEXT = "//";
    private static final String CUSTOM_SPLITTER_SPLITTER = "\\n";

    private SplitterRegex regex;
    private String value;

    public CustomSplitter(String value, SplitterRegex regex) {
        this.value = value;
        this.regex = regex;
        if (hasCustomSplitter(this.value)) {
            regex.addSplitter(getCustomSplitter(this.value));
            this.value = cutCustomSplitterPrefix(this.value);
        }
    }

    public Values getValues() {
        return new Values(Arrays.asList(value.split(regex.get())));
    }

    private String cutCustomSplitterPrefix(String value) {
        return value.substring(CUSTOM_SPLITTER_INDEX);
    }

    private String getCustomSplitter(String value) {
        return value.substring(CUSTOM_SPLITTER_START_INDEX, CUSTOM_SPLITTER_END_INDEX);
    }

    private boolean hasCustomSplitter(String value) {
        String[] split = value.split(CUSTOM_SPLITTER_SPLITTER);
        return split.length == CUSTOM_SPLITTER_START_INDEX
                && split[0].length() == CUSTOM_SPLITTER_END_INDEX
                && split[0].startsWith(CUSTOM_SPLITTER_BEGIN_TEXT);
    }
}
