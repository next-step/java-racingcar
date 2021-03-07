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

    public static Operation of(String inputOperation) {
        for (Operation operation : values()) {
            if (operation.strOperation.equals(inputOperation)) {
                return operation;
            }
        }
        return null;
    }

//    public static Operation isContain(String strOperation, String inputOperation) {
//        if (StringUtils.equals(strOperation, inputOperation)) {
//            return operation;
//        }
//        return null;
//    }

    public static void validate(String inputOperation) {
        if (of(inputOperation) == null) {
            throw new IllegalArgumentException();
        }
    }

}
