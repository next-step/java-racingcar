package calculator.factory;

import calculator.factory.splitter.CustomSeparatorSplitter;
import calculator.factory.splitter.DefaultSplitter;
import calculator.factory.splitter.Splitter;

import java.util.HashMap;
import java.util.Map;

public class SplitterFactory {

    private static final Map<Boolean, Splitter> splitters = new HashMap<>();
    private static final boolean DEFAULT = false;
    private static final boolean CUSTOM = true;

    public SplitterFactory() {
        if (isAlreadyInit()) {
            return ;
        }
        init();
    }

    private void init() {
        Splitter defaultSplitter = new DefaultSplitter();
        Splitter customSeparatorSplitter = new CustomSeparatorSplitter();
        splitters.put(DEFAULT, defaultSplitter);
        splitters.put(CUSTOM, customSeparatorSplitter);
    }

    private boolean isAlreadyInit() {
        return splitters.containsKey(CUSTOM) && splitters.containsKey(DEFAULT);
    }

    public Splitter getSplitter(boolean key) {
        return splitters.get(key);
    }
}
