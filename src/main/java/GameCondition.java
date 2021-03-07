import java.util.Random;

public class GameCondition {
    public static int randomNumber(int range) {
        return new Random().nextInt(range);
    }

    public static boolean isAdvance(int number) {
        return number >= 4;
    }

    public static boolean isInteger(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
