package racingcar.model;

public class StringParser {
    private static final String SEPERATOR = ",";
    public static String[] split(String names){
        return names.split(SEPERATOR);
    }
}
