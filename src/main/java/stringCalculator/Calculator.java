package stringCalculator;

import java.util.Arrays;

public class Calculator {

    public static int calculate(String symbol, int a, int b) {

        return Arrays.stream(Tokenizer.separateToken())
                .filter(operator -> operator.symbol.isSameSymbol(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .execute(symbol,a,b);
    }

    public int executeResult(String token){

        Tokenizer.setSplitToken(token);
        String[] splitToken = Tokenizer.splitToken;
        int result = Integer.parseInt(splitToken[0]);

        for (int i = 1; i < splitToken.length; i += 2) {
            result = calculate(splitToken[i],
                    result,
                    Integer.parseInt(splitToken[i+1]));
        }

        return result;
    }
}
