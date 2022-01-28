package calculator;

import java.util.List;

public class Calculator {

    private final List<String> splitedInput;

    public Calculator(List<String> splitedInput) {
        this.splitedInput = splitedInput;
    }

    public int calculateNumbers() {
        int result = Integer.parseInt(splitedInput.get(0));

        for (int i = Constant.INIT_ARITHMETIC; i < splitedInput.size();
            i += Constant.NEXT_ARITHMETIC) {

            String arithmetic = splitedInput.get(i);
            int number = Integer.parseInt(splitedInput.get(i + 1));

            result = Operator.result(arithmetic, result, number);
        }

        return result;
    }
}
