public class Calculator {

    public String[] splitInput(String input){
        Util.checkEmpty(input);
        return input.split(" ");
    }

    /*
    * 문자열을 입력받아 각 연산자와 피연산자로 구분하여 계산하고 결과값을 반환한다.
    * @param input 입력받을 문자; 비어있지 않아야한다.
    * @return 계산한 결과값
    * @throws IllegalArgumentException 비어있는 문자열을 받을시 발생한다.
    * */
    public int calculate(String input){
        String[] numArr = splitInput(input);
        int result = Util.checkOperand(numArr[0]);
        for(int i=1; i<numArr.length; i+=2){
            int operand = Util.checkOperand(numArr[i+1]);
            Operator operator = Util.checkOperate(numArr[i]);
            result = operator.operate(result, operand);
        }
        return result;
    }




}
