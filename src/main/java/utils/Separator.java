package utils;
import static utils.ConstantCollection.DELIMITER;

public class Separator {
    public static String [] separateName(String carsName) {
        return carsName.split(DELIMITER);
    }
}
