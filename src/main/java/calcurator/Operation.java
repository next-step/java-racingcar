package calcurator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operation {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVISION("/");


    private String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }

    public static List<String> getOperationValues(){
        return Arrays.stream(values()).map((s) -> s.getOperation()).collect(Collectors.toList());
    }

    public static boolean isValidOperation(String str) {
        return getOperationValues().contains(str);

    }



}
