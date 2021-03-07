package step2;

public class Calculator {
    static int calculate(String input){
        Validator.nullEmptyCheck(input);
        String[] expression = input.split(" ");
        int result = Integer.parseInt(expression[0]);
        //TODO 계산식 구현
        return result;
    }
}
