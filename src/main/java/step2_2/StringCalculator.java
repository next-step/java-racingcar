package step2_2;

import java.util.Scanner;
import java.util.function.ToIntBiFunction;


enum Operation{
    PLUS("더하기","+", (a,b)->{return StringCalculator.plus(a,b);}),
    MINUS("빼기","-",(a,b)->{return StringCalculator.minus(a,b);}),
    MULTI("곱하기","*",(a,b)->{return StringCalculator.multiple(a,b);}),
    DIV("나누기","/",(a,b)->{return StringCalculator.divide(a,b);});

    private String operationName ;
    private String operationType ;
    private ToIntBiFunction<Integer,Integer> expression;

    public Integer calculate(int vOne, int vTwo){return expression.applyAsInt(vOne,vTwo);}

    Operation(String operationName, String operationType,ToIntBiFunction<Integer,Integer> expression) {
        this.operationName = operationName;
        this.operationType = operationType;
        this.expression = expression;
    }

    public String getOperationName() { return operationName; }

    public String getOperationType() { return operationType; }

    public ToIntBiFunction<Integer, Integer> getExpression() { return expression; }
}

class CalculatorStart{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        StringCalculator.isBlack(input);
        StringCalculator.isFourOperations(input);

        StringCalculator calculator = new StringCalculator();
        int result = calculator.doCalculate(input);
        System.out.println("result is :"+result);
    }
}

public class StringCalculator {

    static void isBlack(String input) throws IllegalArgumentException{
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("isBlank@func exception!!");
        }
    }
    static void isFourOperations(String input) throws IllegalArgumentException{
        String[] inputs = input.split(" ");

        for(String s :inputs){
            if(! Character.isDigit(s.charAt(0)) && s.length() > 1){
                throw new IllegalArgumentException("isFourOperations@func exception!!!!");
            }
        }
    }

    static int plus(int vOne, int vTwo) {
        return vOne+vTwo;
    }
    static int minus(int vOne, int vTwo){
        return vOne-vTwo;
    }
    static int multiple(int vOne, int vTwo){
        return vOne*vTwo;
    }
    static int divide(int vOne, int vTwo){
        return vOne/vTwo;
    }

    int doCalculate(String input){

        String[] inputs = input.split(" ");
        int result = Integer.parseInt(inputs[0]);

        for (int i =0; i< inputs.length;i++){
            if(inputs[i].equals(Operation.PLUS.getOperationType())){
                result = Operation.PLUS.calculate(result,Integer.parseInt(inputs[i+1]));
            }else if(inputs[i].equals(Operation.MINUS.getOperationType())) {
                result = Operation.MINUS.calculate(result,Integer.parseInt(inputs[i+1]));
            }else if(inputs[i].equals(Operation.MULTI.getOperationType())) {
                result = Operation.MULTI.calculate(result,Integer.parseInt(inputs[i+1]));
            }else if(inputs[i].equals(Operation.DIV.getOperationType())) {
                result = Operation.DIV.calculate(result,Integer.parseInt(inputs[i+1]));
            }
        }
        return result;
    }
}

