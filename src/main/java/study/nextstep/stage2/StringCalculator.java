package study.nextstep.stage2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    interface OperatorHandle{
        double calculate(double land, double rand);
    }

    enum Operator{
        PLUS("+", (land,rand) -> land + rand),
        MINUS("-", (land, rand) -> land - rand),
        MULTIPLY("*", (land, rand) -> land * rand),
        DIVIDE("/", (land, rand) -> land / rand);

        private String operator;
        private OperatorHandle handle;

        Operator(String operator, OperatorHandle handle){
            this.operator = operator;
            this.handle = handle;
        }

        public static double calculate(double land, String operator, double rand){
            for( Operator op : Operator.values() ){
                if( op.operator.equals(operator) ){
                    return op.handle.calculate(land, rand);
                }
            }
            throw new IllegalArgumentException();
        }
    }

    static class StringCalculatorValidator {
        String expression;

        public StringCalculatorValidator(final String expression){
            if( expression == null )
                throw new IllegalArgumentException();
            this.expression = expression;
        }

        public Matcher validateAndMatch(){
            String expr = expression.replaceAll("\\s", "");

            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(expr);

            if( !matcher.find() )
                throw new IllegalArgumentException();

            return matcher;
        }
    }

    public static double calculate(final String expression) throws IllegalArgumentException {
        StringCalculatorValidator validator = new StringCalculatorValidator(expression);
        String expr = expression.replaceAll("\\s", "");
        Matcher matcher = validator.validateAndMatch();

        double exp = Double.parseDouble(matcher.group());
        int endIndex = matcher.end();

        while( matcher.find() ){
            String operator = expr.substring(endIndex, matcher.start());
            double operand = Double.parseDouble(matcher.group());
            endIndex = matcher.end();

            exp = Operator.calculate(exp, operator, operand);
        }
        return exp;
    }
}
