public class StringCalculator {

    private String[] operationType = {"+", "-", "*", "/"};

    public int calculate(String formula){
        String[] input = formula.split(" ");
        int result = Integer.parseInt(input[0]);
        String operator = null;

        for(int i = 1; i < input.length; i++){

            if(isPermittedOperator(input[i])){
                operator = input[i];
            }else{
                result = partCalculate(operator, result, input[i]);
            }

        }

        return result;
    }

    public int partCalculate(String operator, int result, String input){

        if(input == null || input.equals("")) throw new IllegalArgumentException();

        switch (operator){
            case "+":
                return plus(result, input);
            case "-":
                return minus(result, input);
            case "*":
                return multiply(result, input);
            case "/":
                return division(result, input);
            default:
                throw new IllegalArgumentException();
        }

    }

    private boolean isPermittedOperator(String input){

        for(String operator : operationType){
            if(input.equals(operator)) return true;
        }

        return false;
    }

    public int plus(int result, String input){
        return result + Integer.parseInt(input);
    }

    public int minus(int result, String input){
        return result - Integer.parseInt(input);
    }

    public int multiply(int result, String input){
        return result * Integer.parseInt(input);
    }

    public int division(int result, String input){
        return result / Integer.parseInt(input);
    }

}
/*
리뷰어님 안녕하세요, 늘 구현만 급급했고 test 코드를 작성하면서 구현하는 경험은 처음이라 궁금한점이 많습니다.

혹시 테스트 메소드 작성시에 메소드 명에 관한 컨벤션이 따로 존재하는지요?

일단 그냥 "테스트하고자 하는 것 + Test"의 형식으로 네이밍을 하긴 했습니다만, 맞는지 잘 모르겠습니다.
*/