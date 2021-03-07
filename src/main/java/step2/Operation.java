package step2;

public enum Operation {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVISION("/");

    String strOperation;

    Operation(String strOperation) {
        this.strOperation = strOperation;
    }

    public static Integer operator(Integer inputNum1, Integer inputNum2, String inputOperation) {
        Operation operation = getName(inputOperation);
        switch (operation) {
            case PLUS:
                return plus(inputNum1, inputNum2);
            case MINUS:
                return minus(inputNum1, inputNum2);
            case DIVISION:
                return division(inputNum1, inputNum2);
            case MULTIPLE:
                return multiple(inputNum1, inputNum2);
            default:
                throw new IllegalStateException("Unexpected value: " + operation);
        }
    }

    public static Integer minus(Integer input1, Integer input2) {
        return input1 - input2;
    }

    public static Integer plus(Integer input1, Integer input2) {
        return input1 + input2;
    }

    public static Integer multiple(Integer input1, Integer input2) {
        return input1 * input2;
    }

    public static Integer division(Integer input1, Integer input2) {
        return input1 / input2;

    }


    public static Operation getName(String inputOperation) {
        for (Operation operation : values()) {
            if (operation.strOperation.equals(inputOperation)) {
                return operation;
            }
        }
        return null;
    }

    public static void validate(String inputOperation) {
        if (getName(inputOperation) == null) {
            throw new IllegalArgumentException();
        }
    }
}
