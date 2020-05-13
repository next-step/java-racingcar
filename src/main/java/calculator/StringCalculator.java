package calculator;


public class StringCalculator {

    private String input;
    private static final String delimiter = " ";

    public StringCalculator() {  }

    public void setInput(String input) {
        if(!validator(input)) {
            throw new IllegalArgumentException();
        }
        this.input = input;
    }

    public double calculate() {

        String[] calcStringArray = this.input.split(delimiter);
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

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        calculator.setInput("2 + 3 * 4 / 2");
        System.out.println(calculator.calculate());
    }

}
