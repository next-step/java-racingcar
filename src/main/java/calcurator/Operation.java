package calcurator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/");


    private static final Set<String> operationSet = Arrays.stream(values()).map((s) -> s.getOperation()).collect(Collectors.toSet());
    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public static Set<String> getOperationValues() {
        return operationSet;
    }

    public static boolean isValidOperation(String operation) {
        return getOperationValues().contains(operation);
    }

}
