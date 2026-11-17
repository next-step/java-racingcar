package racingcar.view;

public class CountParser {

    public int parse(String input) {
        int count = toInt(input);
        if (count < 0) {
            throw new IllegalArgumentException("negative integer inputs are not allowed here [" + count + "]");
        }
        return count;
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException("only numeric inputs are allowed here", ne);
        }
    }
}
