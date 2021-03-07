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


    Boolean isOperation(String operation) {
        for (Operation operation : Operation.values()) {

        }
    }


}
