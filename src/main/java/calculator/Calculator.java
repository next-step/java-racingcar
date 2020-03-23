package calculator;

import java.util.List;

public class Calculator {

    public int calculate(String text) {
        List<Token> tokens = new Expression().tokenize(text);
        return calculateEachNumbers(tokens);
    }

    private int calculateEachNumbers(List<Token> tokens) {
        int result = 0;

        for(int i=0; i<tokens.size(); i++) {
            Token token = tokens.get(i);
            result = token.calculate(result);
        }

        return result;
    }
}
