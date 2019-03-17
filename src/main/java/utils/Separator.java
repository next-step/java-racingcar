package utils;
import static utils.ConstantCollection.DELIMITER;
import static utils.ConstantCollection.WHITESPACE;

public class Separator {
    public static String [] separateName(String carsName) {
        return carsName.split(DELIMITER + "|" + WHITESPACE);
    }
}
