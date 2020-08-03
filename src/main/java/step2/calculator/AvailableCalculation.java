package step2.calculator;

import step2.common.ExceptionMessage;

public class AvailableCalculation {

    public static String input;

    public AvailableCalculation() {
        throw new IllegalArgumentException();
    }

    public AvailableCalculation(String input) {
        if(input == null || input.equals(""))
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_IS_EMPTY);
        this.input = input;
    }

    public static int calculate(String input){
        String[] splitInput = input.split(" ");
        int num = Integer.parseInt(splitInput[0]);
        for(int i=1; i<splitInput.length; i++){
            Operation operation = Operation.findOperation(splitInput[i]);
            i++;
            num = operation.applyAsInt(num, Integer.parseInt(splitInput[i]));
        }

        return num;
    }
}
