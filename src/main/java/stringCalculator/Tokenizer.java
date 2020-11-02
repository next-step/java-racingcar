package stringCalculator;

public class Tokenizer {

    public static String[] splitToken;

    public static void setSplitToken(String token){
        splitToken = token.split(" ");
    }

    public static Operator[] separateToken() {
        Operator[] operators = new Operator[splitToken.length / 2];

        for (int i = 1; i < splitToken.length; i += 2) {
            operators[i/2] = createOperator(splitToken[i]);
        }

        return operators;
    }

    public static Operator createOperator(String symbol){
        if("+-/*".contains(symbol)) {
            System.out.println("constructor : " + symbol);
            return new Operator(symbol);
        }
        throw new NotVaildOperatorException("올바른 사칙연산 기호를 입력해주세요");
    }
}
