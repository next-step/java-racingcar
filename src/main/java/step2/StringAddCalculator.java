package step2;

public class StringAddCalculator {


    public static int cal(String text) {
        int number = 0;
        if (text == null || text.isBlank()) {
            number = 0;
        } else if (text.length() == 1) {
            number = Integer.parseInt(text);
        } else {
            String[] numbers = text.split(",");
            for (String s : numbers) {
                number += Integer.parseInt(s);
            }
        }
        return number;
    }
    
}
