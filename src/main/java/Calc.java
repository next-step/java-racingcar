
public class Calc {
    public static int calc(String input) {
        String[] values = input.split(" ");
        int first = Integer.parseInt(values[0]);
        int second = Integer.parseInt(values[2]);
        String operator = values[1];
        return calc(operator, first, second);
    }

    private static String[] getOperators(String[] values) {
        String operators = "";
        for (String value :
                values) {
            if("+".equals(value)) operators+=value;
            if("-".equals(value)) operators+=value;
            if("*".equals(value)) operators+=value;
            if("/".equals(value)) operators+=value;
        }
        return operators.split("");
    }

    private static int calc(String operator, int first, int second) {
        if("+".equals(operator)) {
            return first + second;
        }else if("-".equals(operator)) {
            return first - second;
        }else if("*".equals(operator)){
            return first * second;
        }else {
            return first / second;
        }
    }
}
