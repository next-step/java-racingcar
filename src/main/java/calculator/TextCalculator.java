package calculator;

/**
 * @author han
 */
public class TextCalculator {

    public int calculate(String input) {
        String[] strings = input.split(" ");
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 0) {
                result += Integer.parseInt(strings[i]);
            }
        }
        return result;
    }
}
