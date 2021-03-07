package StringCalculator;

import java.util.HashMap;

interface Operation {
    int operation(int operand0, int operand1);
}

class Adder implements Operation {
    @Override
    public int operation(int operand0, int operand1) {
        return operand0 + operand1;
    }
}

class Minus implements Operation {
    @Override
    public int operation(int operand0, int operand1) {
        return operand0 - operand1;
    }
}

class Multiple implements Operation {
    @Override
    public int operation(int operand0, int operand1) {
        return operand0 * operand1;
    }
}

class Divide implements Operation {
    @Override
    public int operation(int operand0, int operand1) {
        return operand0 / operand1;
    }
}

public class StringCalculator {
    HashMap<String, Operation> ops;
    String delim;

    public StringCalculator(String delim) {
        this.delim = delim;
        initOperation();
    }

    public int calculate(String input) {
        String[] tokens = parseInput(input);

        int popIndex = 0;
        int operand0 = Integer.parseInt(tokens[popIndex++]);

        while (popIndex != tokens.length) {
            String operationSymbol = tokens[popIndex++];
            int operand1 = Integer.parseInt(tokens[popIndex++]);
            operand0 = ops.get(operationSymbol).operation(operand0, operand1);
        }
        return operand0;
    }

    void initOperation() {
        ops = new HashMap<String, Operation>();
        ops.put("+", new Adder());
        ops.put("-", new Minus());
        ops.put("*", new Multiple());
        ops.put("/", new Divide());
    }

    String[] parseInput(String input) {
        validateInput(input);
        return input.split(delim);
    }

    private void validateInput(String input) {
        if (input == null)
            throw new IllegalArgumentException("input is null");
        if (input.trim().length() == 0)
            throw new IllegalArgumentException("input is blank");
    }
}