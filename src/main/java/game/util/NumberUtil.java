package game.util;

public class NumberUtil {

    public static Integer toNaturalNumber(String value) {
        int result;
        try {
            result = Integer.parseInt(value);
            if (result <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        return result;
    }
}
