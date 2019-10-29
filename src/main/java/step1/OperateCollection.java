package step1;

import java.util.ArrayList;
import java.util.List;

public class OperateCollection {
    private List<String> operates;

    public OperateCollection() {
        operates = new ArrayList<>();
    }

    public void add(String operate) {
        validateProperOperation(operate);
        operates.add(operate);
    }

    public void validateProperOperation(String operate) {
        if (!operate.equals("+") && !operate.equals("-") && !operate.equals("*") && !operate.equals("/")) {
            throw new IllegalArgumentException(operate);
        }
    }

    public int size() {
        return operates.size();
    }

    public String get(int index) {
        return operates.get(index);
    }
}
