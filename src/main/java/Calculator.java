public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        return num1 / num2;
    }


    /*
    * 연산자와 피연산자를 입력받아 계산하여 반환한다.
    * @param operator 연산자 문자열, num1 피연산자1, num2 피연산자2
    * @return 계산한 결과값
    * @throws IllegalArgumentException 잘못된 연산기호를 받을시 발생한다.
    *  */
    public int operate(String operator, int num1, int num2){
        if(operator.equals("+"))
            return add(num1, num2);
        if(operator.equals("-"))
            return minus(num1, num2);
        if(operator.equals("*"))
            return multiply(num1, num2);
        if(operator.equals("/"))
            return divide(num1, num2);

        throw new IllegalArgumentException("잘못된 연산기호입니다.");
    }

    /*
    * 문자열을 입력받아 각 연산자와 피연산자로 구분하여 계산하고 결과값을 반환한다.
    * @param input 입력받을 문자; 비어있지 않아야한다.
    * @return 계산한 결과값
    * @throws IllegalArgumentException 비어있는 문자열을 받을시 발생한다.
    * */
    public int calculate(String input){
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException("input 값은 비어있을 수 없습니다.");

        String[] numArr = input.split(" ");

        int result = checkOperand(numArr[0]);
        for(int i=1; i<numArr.length; i+=2){
            int operand = checkOperand(numArr[i+1]);
            result = operate(numArr[i], result, operand);
        }

        return result;
    }

    /*
    * String type의 피연산자를 받아 int 형태로 반환한다.
    * @Param operand 피연산자 문자; 숫자 범위 이내여야한다.
    * @return int 타입으로 변환한 형태
    * @throws IllegalArgumentException 숫자가 아닌 문자열을 받을시 발생한다.
    *  */
    public int checkOperand(String operand){
        if(!operand.matches("^[0-9]+$"))
            throw new IllegalArgumentException("피연산자가 잘못되었습니다.");
        return Integer.parseInt(operand);
    }
}
