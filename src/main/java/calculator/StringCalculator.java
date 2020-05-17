package calculator;


public class StringCalculator {

    private static final String delimiter = " ";

    public double calculate(String input) {

        if(!validator(input)) {
            throw new IllegalArgumentException();
        }

        String[] calcStringArray = input.split(delimiter);
        double result = Double.parseDouble(calcStringArray[0]);
        String operatorString = "";

        for(int i = 1; i < calcStringArray.length; i++) {

            operatorString = (isOperatorString(i)) ? calcStringArray[i] : operatorString ;
            result = (isOperatorString(i)) ?
                    result :
                    Operator.getOperatorFunc(operatorString).calculate(result, Double.parseDouble(calcStringArray[i]));

        }

        return result;
    }

    private boolean validator(String input) {
        return !(input == null || input.equals(""));
    }

    private boolean isOperatorString(int number) {
        return (number % 2 == 1);
    }

}
