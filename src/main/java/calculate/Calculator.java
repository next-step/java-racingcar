package calculate;

public class Calculator {
    private final static String SPLIT_REGEX = " ";
    private final static int FIRST_NUMBER_INDEX = 0;
    private final static int FIRST_SIGN_INDEX = 1;
    private final static int JUMP_POINT = 2;
    
    public int calculate(String method) {
        if (!CalculateValidator.isCalculable(method)) {
            throw new IllegalArgumentException();
        }
        
        String[] methodPieces = method.split(SPLIT_REGEX);
        FourArithmeticalRules arithmeticalRule = null;
        int baseNumber = Integer.parseInt(methodPieces[FIRST_NUMBER_INDEX]);
        int nextNumber = 0;
        for (int signIndex = FIRST_SIGN_INDEX; signIndex < methodPieces.length; signIndex += JUMP_POINT) {
            arithmeticalRule = FourArithmeticalRules.getMathSign(methodPieces[signIndex]);
            nextNumber = Integer.parseInt(methodPieces[getNumberIndex(signIndex)]);
            baseNumber = arithmeticalRule.calculate(baseNumber, nextNumber);
        }
        
        return baseNumber;
    }
    
    private int getNumberIndex(int signIndex) {
        return signIndex + 1;
    }
}
