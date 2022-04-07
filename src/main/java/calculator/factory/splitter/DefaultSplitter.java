package calculator.factory.splitter;

import calculator.SeparatorConst;

import java.util.Arrays;
import java.util.List;

public class DefaultSplitter implements Splitter {

    @Override
    public List<String> split(String text) {
        String[] values = text.split(SeparatorConst.DEFAULT_SEPARATOR);
        return toList(values);
    }

    private List<String> toList(String[] values) {
        return Arrays.asList(values);
    }
}
