package calculator;


public class StringCalculator {

    private String calcString;

    public StringCalculator(String calcString) {
        if(!_validator(calcString)) {
            throw new IllegalArgumentException();
        }
        this.calcString = calcString;
    }

    public double calculate() {

        String[] calcStringArray = this.calcString.split(" ");
        double result = Double.parseDouble(calcStringArray[0]);
        double tempNumber;
        String operatorString = "";

        for(int i = 0; i < calcStringArray.length; i++) {

            if(_isOperatorString(i)) {
                operatorString = calcStringArray[i];
                continue;
            }

            if(!_validator(operatorString)) {
                continue;
            }

            tempNumber = Double.parseDouble(calcStringArray[i]);
            result = Operator.getOperatorFunc(operatorString).calculate(result, tempNumber);

        }

        return result;
    }

    private boolean _validator(String input) {
        return !(input == null || input.equals(""));
    }

    private boolean _isOperatorString(int number) {
        return !(number == 0 || number % 2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(new StringCalculator("2 + 3 * 4 / 2").calculate());
    }

}
