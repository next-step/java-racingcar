package step2;

public class Calculator {
    static int calculate(String input){
        //TODO 식 검사하기
        String[] expression = input.split(" ");
        int result = Integer.parseInt(expression[0]);
        //TODO 계산식 구현
        return result;
    }
}
