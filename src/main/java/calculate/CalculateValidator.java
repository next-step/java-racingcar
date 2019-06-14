package calculate;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CalculateValidator {
    public static boolean isCalculable(String[] methodPieces) {
        int methodPiecesSize = methodPieces.length;
 
        return !isEvenNumber(methodPiecesSize) && checkNumbers(methodPieces) && checkMathSigns(methodPieces);
    }
    
    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
    
    private static boolean checkNumbers(String[] methodPieces) {
        return IntStream.range(0, methodPieces.length)
            .filter(i -> isEvenNumber(i))
            .allMatch(i -> StringUtils.isNumeric(methodPieces[i]));
    }
    
    private static boolean checkMathSigns(String[] methodPieces) {
        return IntStream.range(0, methodPieces.length)
            .filter(i -> !isEvenNumber(i))
            .allMatch(i -> { 
                try { 
                    Calculator.getMathSign(methodPieces[i]);
                    return true; 
                } catch (IllegalArgumentException e) { 
                    return false; 
                } 
            });
    }
}
