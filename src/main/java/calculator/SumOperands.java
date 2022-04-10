package calculator;

import java.util.ArrayList;
import java.util.List;

public class SumOperands {
    private final List<SumOperand> sumOperands;

    public SumOperands(List<SumOperand> sumOperands) {
        this.sumOperands = sumOperands;
    }

    public int sum() {
        int result = 0;

        for (SumOperand val : sumOperands) {
            result += val.getValue();
        }

        return result;
    }

    public static SumOperands fromStringList(List<String> list) {
        List<SumOperand> sumOperands = new ArrayList<>();

        for (String stringOperand : list) {
            sumOperands.add(new SumOperand(stringOperand));
        }

        return new SumOperands(sumOperands);
    }
}
