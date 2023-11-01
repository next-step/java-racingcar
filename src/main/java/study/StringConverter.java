package study;

public class StringConverter {

    public static Integer convertToInteger(String text) {
        int value = Integer.parseInt(text);
        if (value < 0) {
            throw new RuntimeException();
        }
        return value;
    }

}
