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
}
