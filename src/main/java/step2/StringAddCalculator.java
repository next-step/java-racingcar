package step2;

public class StringAddCalculator {


    public static int cal(String text) {
        int number = 0;
        if (text == null || text.isBlank()) {
            number = 0;
        } else {
            number = Integer.parseInt(text);
        }
        return number;
    }
}
