import java.util.ArrayList;
import java.util.List;

public class CalculatorContext {

    private List<Token> tokenList = new ArrayList<>();

    public void takeNextToken(Token token) {
        validateNextToken(token);
        tokenList.add(token);
        runOperator();
    }

    public int getResult() {
        return tokenList.get(0).getValue();
    }

    private boolean isNextShouldBeOperator() {
        return tokenList.size() == 1;
    }

    private void validateNextToken(Token token) {
        if (isNextShouldBeOperator() && token.isOperand()) {
            throw new IllegalArgumentException("숫자 담에는 연산자가 와야죠 : " + token.getValue());
        }
    }

    private void runOperator() {
        if (tokenList.size() < 3) {
            return;
        }

        Token operand1 = tokenList.get(0);
        Token operator = tokenList.get(1);
        Token operand2 = tokenList.get(2);

        Token result = operator.operation(operand1, operand2);
        tokenList.clear();
        tokenList.add(result);
    }
}
