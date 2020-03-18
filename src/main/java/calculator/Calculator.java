package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<String> operators = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();

    public Calculator(InputArray inputArray) {
        this.operators = inputArray.getOperators();
        this.numbers = inputArray.getNumbers();
    }

    public double calculateOnePart(int i) {
        return 0;
    }
}
