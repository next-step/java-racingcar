package step1;

public class Operator {

    Validator validator = new Validator();
    Calculator calculator = new Calculator();

    public String operate(String inputString) {

        validator.stringValidation(inputString);
        int result = calculateElements(separateElements(inputString)); //TODO: 질문!
        return String.valueOf(result);
    }

    public String[] separateElements(String inputString) {

        return inputString.split(" ");
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
