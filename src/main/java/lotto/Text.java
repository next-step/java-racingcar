package lotto;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Text {

    private Values values;

    private Text() {
    }

    public Text(String value, String[] splitter) {
        String fullText = value;
        if (StringUtil.isEmpty(fullText)) {
            throw new IllegalArgumentException("Text is empty");
        }
        CustomSplitter customSplitter = new CustomSplitter(value, new SplitterRegex(splitter));
        this.values = customSplitter.getValues();
    }

    public Values getValues() {
        return this.values;
    }

}
