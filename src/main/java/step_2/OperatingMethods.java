package step_2;

import java.util.Arrays;
import java.util.Optional;

public enum OperatingMethods {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/");

    private final String operatorString;

    OperatingMethods(String operatorString) {
        this.operatorString = operatorString;
    }

    public static Optional<OperatingMethods> valueOfString(String text) {
        return Arrays.stream(OperatingMethods.values())
                .filter(method -> method.operatorString.equalsIgnoreCase(text))
                .distinct()
                .findFirst();
    }
}
