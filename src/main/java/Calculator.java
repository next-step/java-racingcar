import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Calculator {

    public int calculate(String input) {
        String[] inputSplitByBlank = splitByBlank(input);
        Validator.valid(inputSplitByBlank);
        return 0;
    }

    private String[] splitByBlank(String input) {
        if (Objects.isNull(input) || input.isEmpty())
            throw new IllegalArgumentException();

        return input.split("\\s");
    }

    private static class Validator {

        static void valid(String[] inputs) {
            for (String input : inputs) {
                if (Numeric.isNumeric(input))
                    continue;

                if (!OperationSymbol.isOperationSymbol(input))
                    throw new IllegalArgumentException();
            }
        }
    }

    private static class Numeric {
        public static boolean isNumeric(String input) {
            return input.matches("-?\\d+(\\.\\d+)?");
        }
    }

    private static class OperationSymbol {
        private static final List<String> SYMBOL_LIST = Collections.unmodifiableList(Arrays.asList("+", "-", "*", "/"));

        public static boolean isOperationSymbol(String input) {
            return SYMBOL_LIST.contains(input);
        }
    }
}
