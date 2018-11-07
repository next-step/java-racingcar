package calculator;

public class DefaultSplitter implements Splitter {
    @Override
    public boolean isSupports(String text) {
        return !text.startsWith("//");
    }

    @Override
    public String[] split(String text) {
        return text.split(",|:");
    }
}
