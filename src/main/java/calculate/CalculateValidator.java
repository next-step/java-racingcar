package calculate;

import org.apache.commons.lang3.StringUtils;

public class CalculateValidator {
    private final static String SPLIT_REGEX = " ";
    
    public static void checkCalculable(String method) {
        if (StringUtils.isEmpty(method)) {
            throwException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
        
        String[] methodPieces = method.split(SPLIT_REGEX);
        if (isEvenNumber(methodPieces.length)) {
            throwException(ErrorMessage.INCORRECT_END_CHARACTER.getMessage());
        }
        
        for (int i = 0, size = methodPieces.length; i < size; i++) {
            String piece = methodPieces[i];
            if (isEvenNumber(i)) {
                validateNumeric(piece);
                continue;
            }
            validateOperator(piece);
        }
    }
    
    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
    
    private static void validateNumeric(String piece) {
        if (StringUtils.isNumeric(piece)) {
            return;
        }
        throwException(ErrorMessage.INCORRECT_NUMBER.getMessage());
    }
    
    private static void validateOperator(String piece) {
        if (Operator.hasMathSign(piece)) {
            return;
        }
        throwException(ErrorMessage.INCORRECT_MATH_SIGN.getMessage());
    }
    
    private static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
}
