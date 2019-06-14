package calculate;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class CalculateValidator {
    final static int MIN_ARRAY_SIZE = 0;
    
    public static boolean isCalculable(String method) {
        if (StringUtils.isEmpty(method)) {
            return false;
        }
        
        String[] methodPieces = method.split(" ");
        return !isEvenNumber(methodPieces.length) && checkNumbers(methodPieces) && checkMathSigns(methodPieces);
    }
    
    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
    
    private static boolean checkNumbers(String[] methodPieces) {
        int methodPiecesSize = methodPieces.length;
        return IntStream.range(MIN_ARRAY_SIZE, methodPiecesSize)
            .filter(i -> isEvenNumber(i))
            .allMatch(i -> StringUtils.isNumeric(methodPieces[i]));
    }
    
    private static boolean checkMathSigns(String[] methodPieces) {
        int methodPiecesSize = methodPieces.length;
        return IntStream.range(MIN_ARRAY_SIZE, methodPiecesSize)
            .filter(i -> !isEvenNumber(i))
            .allMatch(i -> isMathSign(methodPieces[i]));
    }
    
    private static boolean isMathSign(String mathSign) {
        try {
            FourArithmeticalRules.getMathSign(mathSign);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
