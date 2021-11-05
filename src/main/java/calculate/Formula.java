package calculate;

import java.util.*;

public class Formula {
    private final Stack<Integer> numberStack = new Stack<>();
    private final Stack<Operate> operatorStack = new Stack<>();
    private final Map<String, Operate> symbolToOperate = new HashMap<>();

    {
        symbolToOperate.put("+", Operate.ADD);
        symbolToOperate.put("-", Operate.SUBTRACT);
        symbolToOperate.put("*", Operate.MULTIPLY);
        symbolToOperate.put("/", Operate.DIVIDE);
    }

    public Formula(String rawFormula) {
        if (rawFormula == null || rawFormula.trim().isEmpty()) {
            throw new IllegalArgumentException("formula is null or blank");
        }

        String[] tokens = rawFormula.trim().split(" ");
        for (int i = tokens.length - 1; i >= 0; i--) {
            classify(tokens[i]);
        }
    }

    private void classify(String raw) {
        if (isNumeric(raw)) {
            numberStack.push(Integer.parseInt(raw));
        } else {
            Operate operate = symbolToOperate.get(raw);
            if (operate == null) {
                throw new IllegalArgumentException("illegal operator: " + raw);
            }
            operatorStack.push(operate);
        }
    }

    private boolean isNumeric(String raw) {
        try {
            Integer.parseInt(raw);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int calculate() {
        Stack<Integer> numberStack = (Stack<Integer>) this.numberStack.clone();
        Stack<Operate> operatorStack = (Stack<Operate>) this.operatorStack.clone();

        while (!operatorStack.empty()) {
            numberStack.push(
                    operatorStack.pop().calculate(numberStack.pop(), numberStack.pop())
            );
        }
        return numberStack.pop();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula = (Formula) o;
        return numberStack.equals(formula.numberStack) && operatorStack.equals(formula.operatorStack) && symbolToOperate.equals(formula.symbolToOperate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberStack, operatorStack, symbolToOperate);
    }
}
