package study;

public class StringCalculator {

    public double calculate(String input) throws Exception{
        if(isBlank(input)) throw new IllegalArgumentException();

        String[] arr = splitByWhiteSpace(input);
        double calculatedValue = calculateByOperator(arr);

        return calculatedValue;
    }

    boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    String[] splitByWhiteSpace(String input) {
        return input.split(" ");
    }

    double calculateByOperator(String[] arr) throws Exception {
        double result = 0;

        for(int i = 1; i < arr.length - 1; i+=2) {
            Operator o = convertStringToOperator(arr[i]);
            double first = i == 1? Double.parseDouble(arr[i-1]) : result;
            double second = Double.parseDouble(arr[i+1]);

            result = o.operate(first, second);
        }
        return result;
    }

    Operator convertStringToOperator(String s) {
        switch (s) {
            case "+" : return Operator.PLUS;
            case "-" : return Operator.MINUS;
            case "*" : return Operator.MULTIPLY;
            case "/" : return Operator.DIVIDE;
        }
        throw new IllegalArgumentException();
    }
}
