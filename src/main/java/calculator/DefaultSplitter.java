package calculator;

public class DefaultSplitter {
    private final String DEFAULT_SEPARATOR = ",|:";
    protected String[] split(String input){
        return input.split(DEFAULT_SEPARATOR);
    }
}
