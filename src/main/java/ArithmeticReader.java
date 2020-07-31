import java.util.Scanner;
import java.util.regex.Pattern;

public class ArithmeticReader {
    private static final String ARITHMETIC_PATTERN = "\\d+( [-*/+] \\d+)*";
    private final Scanner reader;

    public ArithmeticReader() {
        this.reader = new Scanner(System.in);
    }

    public String read() throws ArithmeticFormatException {
        String expression = reader.nextLine();

        if (isArithmeticExpression(expression)) {
            return expression;
        }

        throw new ArithmeticFormatException(new IllegalArgumentException());
    }

    public boolean isArithmeticExpression(String expression) {
        return Pattern.matches(ARITHMETIC_PATTERN, expression);
    }
}
