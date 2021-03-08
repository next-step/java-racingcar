package study.step2;

public class Calculator {

    public static Integer calcuate(String input){
        if(StringValidator.isBlank(input)) throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        String[] res = input.split(StringValidator.SPLIT_DELIMITER);
        Integer operand = Integer.parseInt(res[0]);
        for(int i=1;i<res.length-1;i=i+2){
            Operations operator = Operations.getOperator(res[i]);
            operand = operator.calculate(operand,Integer.parseInt(res[i+1]));
        }
        return operand;
    }

}
