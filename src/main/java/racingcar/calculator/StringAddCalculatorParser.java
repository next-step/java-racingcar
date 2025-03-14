package racingcar.calculator;

import java.util.Arrays;

public class StringAddCalculatorParser {
    private final StringAddCalculatorLexer.LexicalAnalyzeResult lexicalAnalyzeResult;

    public StringAddCalculatorParser(StringAddCalculatorLexer.LexicalAnalyzeResult lexicalAnalyzeResult) {
        this.lexicalAnalyzeResult = lexicalAnalyzeResult;
    }

    public int[] parse() throws NumberFormatException {
        String str = lexicalAnalyzeResult.getCalcString();
        if (str == null || str.isEmpty())
            return new int[0];

        return convertStringArrayToIntArray(str.split(lexicalAnalyzeResult.getDelimiter()));
//        return Arrays.stream(str.split(lexicalAnalyzeResult.getDelimiter()))
//                .mapToInt(Integer::parseInt)
//                .peek(num -> {
//                    if (num < 0)
//                        throw new NumberFormatException("positive number is allowed.");
//                }).toArray();
    }

    private int[] convertStringArrayToIntArray(String[] split) throws NumberFormatException {
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                result[i] = convertStringToInt(split[i]);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return result;
    }

    private int convertStringToInt(String str) throws NumberFormatException {
        int result = Integer.parseInt(str);
        validateNumberCondition(result);
        return result;
    }

    private void validateNumberCondition(int number) throws NumberFormatException {
        if (number < 0)
            throw new NumberFormatException("positive number is allowed.");
    }
}
