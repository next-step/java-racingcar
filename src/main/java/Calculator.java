import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {
    private static final String SPLIT_REGEX = " ";

    public String calculate(String input) {
        if(checkIfInputIsInvalid(input))
            throw new IllegalArgumentException();

        String[] inputArray = input.split(SPLIT_REGEX);

        if(checkIfInputArrayIsInvalid(inputArray))
            throw new IllegalArgumentException();

        String result = inputArray[0];

        for(int i=1; i<inputArray.length; i+=2)
            result = calculateInternal(result, Symbol.find(inputArray[i]), inputArray[i+1]);

        return result;
    }

    private boolean checkIfInputIsInvalid(String input) {
        return input == null || input.equalsIgnoreCase("");
    }

    private boolean checkIfInputArrayIsInvalid(String[] inputArray) {
        return inputArray.length < 3 || inputArray.length % 2 != 1;
    }

    private String calculateInternal(String strNum1, Symbol symbol, String strNum2) {
        int num1 = Integer.parseInt(strNum1);
        int num2 = Integer.parseInt(strNum2);

        Calculation calculation;

        switch (symbol) {
            case PLUS:
                calculation = new Plus(num1, num2);
                break;
            case MINUS:
                calculation = new Minus(num1, num2);
                break;
            case MULTIPLY:
                calculation = new Multiply(num1, num2);
                break;
            case DIVIDE:
                calculation = new Divide(num1, num2);
                break;
            default:
                throw new IllegalArgumentException();
        }

        return String.valueOf(calculation.getResult());
    }

    enum Symbol {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/");

        String symbol;

        Symbol(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        private static final Map<String, Symbol> symbols =
                Collections.unmodifiableMap(Stream.of(values())
                        .collect(Collectors.toMap(Symbol::getSymbol, Function.identity())));

        public static Symbol find(String symbol) {
            return Optional.ofNullable(symbols.get(symbol)).orElseThrow(IllegalArgumentException::new);
        }
    }
}
