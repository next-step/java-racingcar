package calculator;

public class Calculator {

    private final String splitter;
    private final StringValidator stringValidator;

    public Calculator(){
        this(" ");
    }

    public Calculator(String splitter){
        this.splitter = splitter;
        this.stringValidator = new StringValidator();
    }

    public Double calculate(String input) {
        stringValidator.validateNotEmpty(input);

        String[] elements = parseInput(input);

        OperandNumber firstOperand = new OperandNumber(elements[0]);
        int elementSize = elements.length;
        for (int i = 1; i < elementSize; i+=2) {
            String operatorElement = elements[i];
            OperandNumber secondOperand = new OperandNumber(elements[i+1]);
            Operator operator = Operator.find(operatorElement).orElseThrow(() -> new IllegalArgumentException(String.format("not supported operator : %s", operatorElement)));
            firstOperand = operator.operate(firstOperand, secondOperand);
        }

        return firstOperand.doubleValue();
    }

    private String[] parseInput(String input){
        input = input.trim();
        String[] elements = input.split(splitter);

        if(elements.length < 3 || (elements.length % 2 ==0)){
            throw new IllegalArgumentException("invalid input");
        }

        return elements;
    }

}
