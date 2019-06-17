package calculate;

public class Calculator {
    private final static String SPLIT_REGEX = " ";
    private final static int FIRST_NUMBER_INDEX = 0;
    private final static int FIRST_SIGN_INDEX = 1;
    private final static int JUMP_POINT = 2;
    private final static int NEXT_POINT = 1;
    
    public static int calculate(String fomula) {
        String[] fomulaPieces = fomula.split(SPLIT_REGEX);
        int baseNumber = Integer.parseInt(fomulaPieces[FIRST_NUMBER_INDEX]);
        for (int i = FIRST_SIGN_INDEX; i < fomulaPieces.length; i += JUMP_POINT) {
            Operator operator = Operator.getMathSign(fomulaPieces[i]);
            int nextNumber = Integer.parseInt(fomulaPieces[i + NEXT_POINT]);
            baseNumber = operator.calculate(baseNumber, nextNumber);
        }
        
        return baseNumber;
    }
}