package stringCalculator;

public class Tokenizer {

    private static String[] splitToken;

    public static void makeAndSetSplitToken(String token){
        splitToken = token.split(" ");
    }

    public static String[] getSplitToken(){
        return splitToken;
    }

    public static void separateToken() {
        for (int i = 1; i < splitToken.length; i += 2) {
            createOperator(splitToken[i]);
        }
    }

    public static void createOperator(String symbol){
        if(!Operator.containsSymbol(symbol)) {
            throw new NotVaildOperatorException("올바른 사칙연산 기호를 입력해주세요");
        }
        Operator.addSymbol(symbol);
    }
}
