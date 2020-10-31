package step4.utils;

public class CarNameSplitter {
    private static final String SPLIT_SEPARATOR = ",";

    public static String[] splitter(String input){
        return input.split(SPLIT_SEPARATOR);
    }
}
