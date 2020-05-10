package study.nextstep.stage2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    interface OperatorHandle{
        double calculate(double land, double rand);
    }

    static Map<String, OperatorHandle> operatorMap = new HashMap<String, OperatorHandle>() {{
        put("+", (land, rand) -> land + rand);
        put("-", (land, rand) -> land - rand);
        put("*", (land, rand) -> land * rand);
        put("/", (land, rand) -> land / rand);
    }};

    public static double calculate(final String expression) throws IllegalArgumentException {
        if( expression == null )
            throw new IllegalArgumentException();
        String expr = expression.replaceAll("\\s", ""); // eliminate space character

        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(expr);
        if( !matcher.find() )
            throw new IllegalArgumentException();

        double exp = Double.parseDouble(matcher.group());
        int endIndex = matcher.end();

        while( matcher.find() ){
            String operator = expr.substring(endIndex, matcher.start());
            double operand = Double.parseDouble(matcher.group());
            endIndex = matcher.end();

            if( !operatorMap.containsKey(operator) )
                throw new IllegalArgumentException();

            exp = operatorMap.get(operator).calculate(exp, operand);
        }
        return exp;
    }
}
