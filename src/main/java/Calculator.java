import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    private static final String PLUS_SYMBOL = "+";
    private static final String MINUS_SYMBOL = "-";
    private static final String MULTIPLY_SYMBOL = "*";
    private static final String DIVIDE_SYMBOL = "/";

    private static final List<String> ENABLED_SYMBOLS = Arrays.asList(PLUS_SYMBOL, MINUS_SYMBOL, MULTIPLY_SYMBOL, DIVIDE_SYMBOL);

    public int process(String input) {

        validateInput(input);
        List<String> tokens = tokenize(input);
        validateToken(tokens);

        return calculate(tokens);
    }

    void validateInput(String input) {

        if (input == null || isConsistOnlyWhiteSpace(input)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
    }

    List<String> tokenize(String input) {

        return IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .map(String::valueOf)
                .filter(token -> !isConsistOnlyWhiteSpace(token))
                .collect(Collectors.toList());
    }

    void validateToken(List<String> tokens) {

        validateTokenSize(tokens);
        validateSymbol(tokens);
    }

    private boolean isConsistOnlyWhiteSpace(String input) {

        return input.trim().isEmpty();
    }

    private void validateTokenSize(List<String> tokens) {

        if (tokens.size() < 3 || tokens.size() % 2 != 1) {
            throw new IllegalArgumentException("연산자의 개수가 유효하지 않습니다.");
        }
    }

    private void validateSymbol(List<String> tokens) {

        IntStream.range(0, tokens.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(tokens::get)
                .forEach(token -> {
                    if (!isSymbol(token)) {
                        throw new IllegalArgumentException("연산기호가 유효하지 않습니다.");
                    }
                });
    }

    private boolean isSymbol(String token) {

        return ENABLED_SYMBOLS.contains(token);
    }

    public int calculate(List<String> tokens) {

        int result = Integer.valueOf(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {
            result = calculate(result, tokens.get(i), tokens.get(i + 1));
        }

        return result;
    }

    private int calculate(int result, String symbol, String number) {

        if (PLUS_SYMBOL.equals(symbol)) {
            return result + Integer.valueOf(number);
        }
        if (MINUS_SYMBOL.equals(symbol)) {
            return result - Integer.valueOf(number);
        }
        if (MULTIPLY_SYMBOL.equals(symbol)) {
            return result * Integer.valueOf(number);
        }
        if (DIVIDE_SYMBOL.equals(symbol)) {
            return result / Integer.valueOf(number);
        }

        throw new IllegalArgumentException("연산기호가 유효하지 않습니다.");
    }
}
