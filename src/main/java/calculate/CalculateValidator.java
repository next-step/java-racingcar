package calculate;

import org.apache.commons.lang3.StringUtils;
import java.util.stream.IntStream;

public class CalculateValidator {
    private final static int MIN_ARRAY_SIZE = 0;
    private final static String SPLIT_REGEX = " ";
    
    public static void checkCalculable(String method) {
        if (StringUtils.isEmpty(method)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
        
        String[] methodPieces = method.split(SPLIT_REGEX);
        if (isEvenNumber(methodPieces.length)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_END_CHARACTER.getMessage());
        }
        
        if (!checkNumbers(methodPieces)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_NUMBER.getMessage());
        }
        
        if (!checkMathSigns(methodPieces)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_MATH_SIGN.getMessage());
        }
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
            .allMatch(i -> Operator.hasMathSign(methodPieces[i]));
    }
}
