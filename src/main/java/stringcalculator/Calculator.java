package stringcalculator;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class Calculator {

    enum Operator{
        PLUS("+", (operand1, operand2) -> operand1 + operand2),
        MINUS("-", (operand1, operand2) -> operand1 - operand2),
        MULTIPLE("*", (operand1, operand2) -> operand1 * operand2),
        DIVIDE("-", (operand1, operand2) -> operand1 / operand2);

        private BiFunction<Double, Double, Double> mathExpression;
        private String operator;

        //  생성자
        Operator(String operator, BiFunction<Double, Double, Double> mathExpression) {
            this.operator = operator;
            this.mathExpression = mathExpression;
        }

        //  계산기능 구현
        public double calculate(double operand1, double operand2) {
            return this.mathExpression.apply(operand1, operand2);
        }
    }


    //  연산식으로 만들기
    public String trimInputExpression(String targetExpression){
        return targetExpression.replace(" ", "");
    }

    //  람다식으로 만들어서 리스트에서 뽑아서 계산
    //  고려 해야할 점 double로 만들기?

    public double calculate(String[] operators, String[] operands){
        //String operands[] = trimmedExpression.replaceAll("[^0-9]","").split("");  //  연산자 리스트
        //String operators[] = trimmedExpression.replaceAll("[0-9]", "").split("");       //  피연산자 리스트

        double result = Double.parseDouble(operands[0]);


        for(int i=0; i< operators.length; i++){
            switch (operators[i]){
                case "+":
                    result += Double.parseDouble(operands[i+1]);
                    break;
                case "-":
                    result -= Double.parseDouble(operands[i+1]);
                    break;
                case "*":
                    result *= Double.parseDouble(operands[i+1]);
                    break;
                case "/":
                    result /= Double.parseDouble(operands[i+1]);
                default:
                    break;
            }
        }

        return result;
    }

    public boolean isNotValidOperator(String inputExpression){
        String trimmedExpression = inputExpression.replace(" ", "").replaceAll("[0-9]", "");
        String operators = "+-*/";
        for(int i=0; i< trimmedExpression.length(); i++){
            if(!operators.contains(trimmedExpression.substring(i, i+1))){
                throw new IllegalArgumentException("잘못된 연산자 기호: "+ trimmedExpression.substring(i, i+1));
            }
        }

        return true;
    }

}
