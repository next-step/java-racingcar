package humbledude.stringcalculator;

public interface Token {

    boolean isOperand();
    Token operation(Token operand1, Token operand2);
    int getValue();
}
