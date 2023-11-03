package calculator;

import java.util.List;

public class Operator {
    private final List<Integer> digits;

    public Operator(CalcNumbers calcNumbers) {
        this.digits = calcNumbers.digits();
    }

    public int sum() {
        return digits.stream().reduce(0, Integer::sum);
    }
}
