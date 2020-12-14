package lotto;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Text {
    private static final int CUSTOM_SPLITTER_INDEX = 4;
    private static final int CUSTOM_SPLITTER_START_INDEX = 2;
    private static final int CUSTOM_SPLITTER_END_INDEX = 3;
    private static final String CUSTOM_SPLITTER_BEGIN_TEXT = "//";
    private static final String CUSTOM_SPLITTER_SPLITTER = "\\n";

    private SplitterRegex regex;
    private List<String> values;

    private Text() {
    }

    public Text(String value, String[] splitter) {
        String fullText = value;
        if (StringUtil.isEmpty(fullText)) {
            throw new IllegalArgumentException("Text is empty");
        }
        this.regex = new SplitterRegex(splitter);
        if (hasCustomSplitter(fullText)) {
            regex.addSplitter(getCustomSplitter(fullText));
            fullText = cutCustomSplitterPrefix(fullText);
        }
        this.values = textToList(fullText);
    }

    public List<String> getValues() {
        return this.values;
    }

    private String cutCustomSplitterPrefix(String value) {
        return value.substring(CUSTOM_SPLITTER_INDEX);
    }

    private List<String> textToList(String text) {
        List<String> list = Arrays.asList(text.split(regex.get()));
        boolean onlyNumber = list.stream().allMatch(StringUtil::isNumber);
        if (!onlyNumber) {
            throw new RuntimeException("Unexpected character contained");
        }
        return Arrays.asList(text.split(regex.get()));
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
