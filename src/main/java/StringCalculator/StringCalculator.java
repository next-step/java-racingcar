package StringCalculator;

import java.util.HashMap;

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
    InputParser inputParser;

    public StringCalculator(InputParser inputParser) {
        if (inputParser == null) {
            throw new IllegalArgumentException("inputParser is null");
        }
        this.inputParser = inputParser;
        initOperation();
    }

    public int calculate(String input) {
        inputParser.parse(input);
        int operand0 = Integer.parseInt(inputParser.pop());

        while (!inputParser.isEmpty()) {
            String operationSymbol = inputParser.pop();
            int operand1 = Integer.parseInt(inputParser.pop());
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
}