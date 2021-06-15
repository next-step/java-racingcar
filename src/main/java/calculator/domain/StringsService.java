package calculator.domain;

import java.util.regex.Pattern;

public class StringsService {
    private static final Pattern SYMBOL_PATTERN = Pattern.compile("[\\d\\+\\-\\*\\/]");

    public static boolean isBlank(String inputFormula) {
        if (inputFormula == null || inputFormula.trim().isEmpty()) {
            throw new IllegalArgumentException("input is null or blank");
        }
        return true;
    }

    public static boolean checkSymbol(String[] splitFormula) {

        for (int i = 0; i < splitFormula.length; i++) {
            if (SYMBOL_PATTERN.matcher(splitFormula[i]).matches()) {
                return true;
            }
        }
        throw new IllegalArgumentException("symbol error");

    }

    public static int calculateSplitedString(String[] splitFormula) {
        int result = Integer.parseInt(splitFormula[0]);
        for (int i = 0; i < splitFormula.length - 2; i += 2) {
            result = result(splitFormula[i + 1], result, splitFormula[i + 2]);
        }
        return result;
    }

    private static int result(String symbol, int firstNumber, String lastNumber) {
        return findBySymbol(symbol).result(firstNumber, Integer.parseInt(lastNumber));
    }

    private static Operation findBySymbol(String symbol) {
        return Operation.findBySymbol(String.valueOf(symbol));
    }

}
