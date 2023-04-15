package race.util;

public class Split {

    private static final String DELIMITER = ",";

    private Split(){}

    public static String[] getNames(String text) {
        return text.split(DELIMITER);
    }
}
