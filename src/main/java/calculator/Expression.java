package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final Pattern operationPattern = Pattern.compile("^[-+*/]");
    private static final Pattern operandPattern = Pattern.compile("^\\d*");
    private String expression;
    private List<Token> tokens;

    public Expression() {
        this.tokens = new ArrayList<>();
    }

    public List<Token> tokenize(final String text) throws IllegalArgumentException {
        if(StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈문자열");
        }

        expression = getExpression(text);
        return parseAll();
    }

    private List<Token> parseAll() {
        while(expression.length() > 0) {
            parse();
        }
        return new ArrayList<>(tokens);
    }

    private void parse() {
        try {
            tokens.add(new Token(extractOperation(), Integer.parseInt(extractOperand())));
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException(ex.getCause());
        }
    }

    private String extractOperand() {
        Matcher operandMatcher = operandPattern.matcher(expression);
        String operand = "";
        if (operandMatcher.find()) {
            operand = operandMatcher.group();
            expression = expression.substring(operand.length());
        }
        return operand;
    }

    private String extractOperation() {
        Matcher operationMatcher = operationPattern.matcher(expression);
        String operation = "";
        if(operationMatcher.find()) {
            operation = operationMatcher.group();
            expression = expression.substring(operation.length());
        }
        return operation;
    }

    private String getExpression(String text) {
        if(!text.startsWith("-")) {
            text = "+" + text;
        }
        return text;
    }
}
