package step1;

public class Operator {

    Validator validator = new Validator();

    public String operate(String inputString) {

        String[] inputElements = inputString.split(" ");
        int calculationResult = Integer.parseInt(inputElements[0]);

        for(int i=1; i<inputElements.length; i+=2) {
            validator.operatorTypeValidation(inputElements[i]);
            calculationResult = calculate(inputElements[i], calculationResult, inputElements[i+1]);
        }
        return String.valueOf(calculationResult);
    }
}
