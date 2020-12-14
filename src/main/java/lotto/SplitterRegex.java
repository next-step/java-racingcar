package lotto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitterRegex {
    private static final String START = "[";
    private static final String END = "]";

    private ArrayList<String> splitters;

    private SplitterRegex() {

    }

    public SplitterRegex(String... splitters) {
        this.splitters = new ArrayList<>(Arrays.asList(splitters));
    }

    public void addSplitter(String splitter) {
        this.splitters.add(splitter);
    }

    public String get() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START);
        this.splitters.forEach(stringBuilder::append);
        stringBuilder.append(END);
        return stringBuilder.toString();
    }


}
