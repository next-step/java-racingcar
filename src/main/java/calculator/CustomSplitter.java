package calculator;
public class CustomSplitter {
    private final String CUSTOM_SEPARATOR = "//(.*)\\n(.*)";
    protected String[] split(String input){
        return input.split(CUSTOM_SEPARATOR);
    }
}
