package calculator;

public interface Splitter {
    boolean isSupports(String text);

    String[] split(String text);
}
