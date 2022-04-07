package calculator.factory.splitter;

import calculator.SeparatorConst;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparatorSplitter implements Splitter {

    @Override
    public List<String> split(String text) {
        Matcher matcher = Pattern.compile(SeparatorConst.CUSTOM_SEPARATOR_REGEX_PATTERN).matcher(text);
        matcher.find();
        String customSeparator = matcher.group(1);
        String[] values = matcher.group(2).split(customSeparator);
        return toList(values);
    }

    private List<String> toList(String[] values) {
        return Arrays.asList(values);
    }
}
