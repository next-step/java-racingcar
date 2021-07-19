package study.calculator;

public class Common {
    public static void checkValue(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("input Value is null or blank");
            throw new IllegalArgumentException("input Value is null or blank");
        }
    }

    public static void checkOperation(String operation) {
        if (isaBoolean(operation)) {
            System.out.println("input operation is wrong");
            throw new IllegalArgumentException("input operation is wrong");
        }

    }

    private static boolean isaBoolean(String operation) {
        return operation.indexOf("+") == -1 ||
                operation.indexOf("-") == -1 ||
                operation.indexOf("*") == -1 ||
                operation.indexOf("/") == -1;
    }
}
