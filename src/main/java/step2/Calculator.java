package step2;

public class Calculator {
    public int sum(int num1, int num2) {

        return num1+num2;
    }

    public int subtract(int num1, int num2) {
        return num1-num2;
    }

    public int multiply(int num1, int num2) {
        return num1*num2;
    }

    public int divide(int num1, int num2) {
        return num1/num2;
    }

    public int calculate(String input) {
        //빈문자열일 경우
        if(input.trim().length() == 0 || input == null){
            throw new IllegalStateException("빈 문자열입니다.");
        }

        String[] elements = input.split(" ");
        int result = Integer.parseInt(elements[0]);

        for(int i=1; i<elements.length; i+=2){
            int next = Integer.parseInt(elements[i+1]);

            if(elements[i].equals("+")){
                result = sum(result, next);
            }else if(elements[i].equals("-")){
                result = subtract(result, next);
            }else if(elements[i].equals("*")){
                result = multiply(result, next);
            }else if(elements[i].equals("/")){
                result = divide(result, next);
            }else{
                throw new IllegalStateException("사칙연산 기호가 아닙니다.");
            }
        }

        return result;
    }
}
