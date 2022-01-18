import java.util.ArrayList;
import java.util.List;

public class Number {

    private final List<Integer> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }

    public void addNumber(String num) {
        if (!Character.isDigit(num.charAt(0))) {
            throw new NumberFormatException("숫자가 아닙니다");
        }
        numbers.add(Integer.valueOf(num));
    }

    public void print() {
        System.out.println("Number Class========");
        for (Integer i : numbers) {
            System.out.println(i);
        }
    }
}
