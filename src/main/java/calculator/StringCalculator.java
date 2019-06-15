package calculator;


import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    public static SymbolType getSymbolType(String symbol) {
        return SymbolType.getOperator(symbol);
    }

    public static String[] parseString(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException("Input string is not valid. Input : " + input);
        }
        String[] parsedString = input.split(" ");

        if (parseNumberList(parsedString).size() - 1 != parseOperatorList(parsedString).size()) {
            throw new IllegalArgumentException("Not calculatable string. String: " + input);
        }

        return parsedString;
    }

    private static List<Double> parseNumberList(String[] input) {
        Pattern numberPattern = Pattern.compile("\\d+");
        return Arrays.stream(input)
                .filter(element -> numberPattern.matcher(element).find())
                .map(doubleString -> Double.parseDouble(doubleString))
                .collect(Collectors.toList());
    }

    private static List<SymbolType> parseOperatorList(String[] input) {
        Pattern operatorPattern = Pattern.compile("(\\+|\\-|\\*|\\/)");
        return Arrays.stream(input)
                .filter(element -> operatorPattern.matcher(element).find())
                .map(operatorString -> SymbolType.getOperator(operatorString))
                .collect(Collectors.toList());
    }

    private static double calculateNext(double current, List<Double> numberList, SymbolType currentOperator) {
        double inputNumber = numberList.remove(0);

        return Calculator.calculateByOperator(current, inputNumber, currentOperator);
    }

    public static double calculate(String input) {
        String[] parsedString = parseString(input);
        List<Double> numberList = parseNumberList(parsedString);
        List<SymbolType> symbolList = parseOperatorList(parsedString);

        double result = numberList.remove(0);
        for (SymbolType symbolType :symbolList) {
            result = calculateNext(result, numberList, symbolType);
        }
        return result;
    }
}
