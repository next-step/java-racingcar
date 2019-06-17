package step1;

public class Operator {

    Validator validator = new Validator();
    Calculator calculator = new Calculator();

    public String operate(String inputString) {

        validator.stringValidation(inputString); //TODO: 처음에는 이 부분을 runCalculatorApplication 메서드에 두었었는데요, 공백과 null을 체크하는 이 메서드를 어디서 실행하는게 좋을까요?
        String[] separatedElements = inputString.split(" ");
        int result = calculateElements(separatedElements);
        return String.valueOf(result); //TODO: 이렇게 반환하는 것이 올바른 방법인지 의문입니다.
    }

    public int calculateElements(String[] separatedElements) {

        int calculationResult = Integer.parseInt(separatedElements[0]);
        for(int i=1; i<separatedElements.length; i+=2) {
            String operatorType = separatedElements[i]; //TODO: separatedElements[i]가 연산자를 뜻한다는 것을 파악하기 쉽도록 변수에 담아서 사용했는데요, 불필요할까요?
            validator.operatorTypeValidation(operatorType);
            calculationResult = calculator.calculate(operatorType, calculationResult, separatedElements[i+1]);
        }
        return calculationResult;
    }

}
