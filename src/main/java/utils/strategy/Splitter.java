package utils.strategy;

public interface Splitter {
    String defaultDelimiter = ",|:";

    boolean isSupport(String input);

    String[] split(String input);
}
