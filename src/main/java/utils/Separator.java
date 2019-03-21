package utils;

public class Separator {
    public static final String WHITESPACE = " ";
    public static final String DELIMITER = ",";

    public static String [] separateName(String carsName) {
        return carsName.split(DELIMITER + "|" + WHITESPACE);
    }
}
