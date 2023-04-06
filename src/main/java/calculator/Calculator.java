package calculator;

import java.util.List;

public class Calculator {
    public int sum(List<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }
}
