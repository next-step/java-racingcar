package utils.strategy;

public class DefaultSplitter implements Splitter {
    @Override
    public boolean isSupport(String input) {
        return true;
    }

    @Override
    public String[] split(String input) {
        return input.split(defaultDelimiter);
    }
}
