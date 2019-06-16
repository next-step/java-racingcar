package step1;

public class Operator {

    Validator validator = new Validator();
    Calculator calculator = new Calculator();

    public String operate(String inputString) {

        validator.stringValidation(inputString);
        String[] separatedElements = inputString.split(" ");
        int result = calculateElements(separatedElements);
        return String.valueOf(result);
    }

    public int calculateElements(String[] separatedElements) {

        int calculationResult = Integer.parseInt(separatedElements[0]);
        for(int i=1; i<separatedElements.length; i+=2) {
            String operatorType = separatedElements[i];
            validator.operatorTypeValidation(operatorType);
            calculationResult = calculator.calculate(operatorType, calculationResult, separatedElements[i+1]);
        }
        return calculationResult;
    }

}
