package calculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorTargetInts {
    private final List<CalculatorTargetInt> list = new ArrayList<>();

    public CalculatorTargetInts(List<String> stringList) {
        for (String str : stringList) {
            list.add(new CalculatorTargetInt(str));
        }
    }

    public List<CalculatorTargetInt> getList() {
        return list;
    }
}
