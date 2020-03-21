public class Calculator {

    public static double calculate(String str) {
        String[] split = str.split(" ");
        double x = Double.parseDouble(split[0]);
        double y = Double.parseDouble(split[2]);
        Operator operator = Operator.findOperator(split[1]);
        return  operator.apply(x, y);
    }
}
