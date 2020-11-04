package stringCalculator;

public class Calculator {

    public static int calculate(String symbol, int a, int b) {

        Tokenizer.separateToken();
        Operator.containsSymbol(symbol);

        return Operator.execute(symbol, a, b);
    }

    public int executeResult(String token){

        Tokenizer.makeAndSetSplitToken(token);
        String[] splitToken = Tokenizer.getSplitToken();
        int result = Integer.parseInt(splitToken[0]);

        for (int i = 1; i < splitToken.length; i += 2) {
            result = calculate(splitToken[i],
                    result,
                    Integer.parseInt(splitToken[i+1]));
        }

        return result;
    }
}
