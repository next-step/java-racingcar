package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final Pattern operationPattern = Pattern.compile("^[-+*/]");
    private static final Pattern numberPattern = Pattern.compile("^\\d*");

    public List<Token> tokenize(String text) throws IllegalArgumentException {
        if(StringUtils.isEmpty(text)) {
            throw new IllegalArgumentException("입력 값이 null 이거나 빈문자열");
        }
        return parse(getExpression(text));
    }

    private List<Token> parse(String expression) {
        List<Token> tokens = new ArrayList<>();

        while(expression.length() > 0) {
            Matcher operationMatcher = operationPattern.matcher(expression);
            String operation = "";
            if(operationMatcher.find()) {
                operation = operationMatcher.group();
                expression = expression.substring(operation.length());
            }

            Matcher numberMatcher = numberPattern.matcher(expression);
            String number = "";
            if(numberMatcher.find()) {
                number = numberMatcher.group();
                expression = expression.substring(number.length());
            }

            tokens.add(new Token(operation, Integer.parseInt(number)));
        }
        return tokens;
    }

    private String getExpression(String text) {
        if(!text.startsWith("-")) {
            text = "+" + text;
        }
        return text;
    }
}
