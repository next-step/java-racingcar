package stringcalculator.stringcalculator;

public class StringCalculator {
    public double calculate(String equation){
        if(equation.contains("+")){
            return processAddition(equation);
            //processAddition - refactoring
            //String[] components = equation.split("\\+");
            //return calculate(components[0]) + calculate(components[1]);
        }
        if (equation.matches("[0-9]+")){
            return Double.parseDouble(equation);
        }
        return Double.NaN;
    }

    private double processAddition(String equation){
        String[] components = equation.split("\\+");
        return calculate(components[0]) + calculate(components[1]);
    }

    public static int split_add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] values = text.split(",|:");
        return sum(values);
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String value : values) {
            result += Integer.parseInt(value);
        }
        return result;
    }
    //not_calculable_symbol

    //add~multiple (divide : round )
}
