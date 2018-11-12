package calculator2;

import java.util.ArrayList;
import java.util.List;

public class StringNumber {

    List<Integer> numbers;

    public StringNumber(String[] values) {
        this.numbers = toInts(values);
    }

    private List<Integer> toInts(String[] values) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < values.length ; i++) {
            temp.add(toPositive(values[i]));
        }
        return temp;
    }

    private Integer toPositive(String value) {
        int number = Integer.parseInt(value);
        if(number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    public int sum() {
        int sum = 0;
        for (Integer number : this.numbers) {
            sum += number;
        }
        return sum;
    }

}
