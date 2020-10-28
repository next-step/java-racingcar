package calc;

public class StringCalculatorTestCase {

    // VALID
    public static final String ONE = "1"; // 1
    public static final String START_WITH_MINUS_ONE = "- 1"; // -1
    public static final String PLUS_ONE = "+ 1"; // 1
    public static final String HAS_ONE_OPERATOR = "1 + 2"; // 3
    public static final String START_WITH_MINUS_HAS_ONE_OPERATIOR = "- 1 + 2"; // 1
    public static final String START_WITH_PLUS_HAS_ONE_OPERATIOR = "+ 1 + 2"; // 3
    public static final String HAS_MANY_OPERATOR = "1 + 2 - 3 * 4 / 5"; // 0
    public static final String START_WITH_MINUS_HAS_MANY_OPERATIOR = "- 1 + 2 - 3 * 4 / 5"; // -1
    public static final String START_WITH_PLUS_HAS_MANY_OPERATIOR = "+ 1 + 2 - 3 * 4 / 5"; // 0
    public static final String HAS_LARGE_NUMBER = "115 + 35 - 50 * 10 / 100"; // 10
    public static final String START_WITH_MINUS_HAS_LARGE_NUMBER = "- 115 + 15 - 50 * 10 / 100"; // -15
    public static final String START_WITH_PLUS_HAS_LARGE_NUMBER = "+ 115 + 35 - 50 * 10 / 100"; // 10

    // INVALID
    public static final String DIVIDE_ZERO = "5 / 0";
    public static final String HAS_NO_OPERAND = "- 1 + 2 - 3 * 4 / 5 -";
    public static final String HAS_DOUBLE_OPERATOR = "- 1 + 2 - 3 * 4 / - 5 -";
    public static final String BLANK = " ";
    public static final String NULL = null;
}
