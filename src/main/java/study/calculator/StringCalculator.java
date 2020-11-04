package study.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private static final String CALCULATOR_DELIMITER = " ";

    public static String getCalculationResult(String toCalculateValue){
        isEmptyInput(toCalculateValue);

        String[] input = toCalculateValue.split(CALCULATOR_DELIMITER);

        List<Integer> operand = new ArrayList<Integer>();
        List<String> operator = new ArrayList<String>();


        int inputLength = input.length;

        for(int i=0; i<inputLength; i++){
            if(i%2 == 0){
                isNumericString(input[i]);
                operand.add(Integer.parseInt(input[i]));
            }else{
                isCorrectOperator(input[i]);
                operator.add(input[i]);

            }
        }

        int calculationResult = 0;
        int operandSize = operand.size();
        int operatorSize = operator.size();


        if(operandSize != operatorSize+1){
            throw new IllegalArgumentException(CustomErrorMessage.UNCOMPLETED_INPUT.getErrorMessage());
        }

        for(int j=0; j<operandSize; j++){
            if(j == operandSize - 1){
                break;
            }else{
                CalculateSet calculateSet;
                if(j == 0){
                    calculateSet = new CalculateSet(operand.get(j), operand.get(j+1));
                }else{
                    calculateSet = new CalculateSet(calculationResult, operand.get(j+1));
                }
                String operatorValue = operator.get(j);
                calculationResult = Operator.calculate(operatorValue,calculateSet);
                
            }
        }
        
        return String.valueOf(calculationResult);
    }

    private static void isCorrectOperator(String input) {
        if(!input.matches("([+\\-*\\/])")){
            throw new IllegalArgumentException(CustomErrorMessage.ILLEGAL_OPERATOR.getErrorMessage());
        }
    }

    private static void isNumericString(String input) {
        if(!input.matches("-?\\d+")){
            throw new IllegalArgumentException(CustomErrorMessage.ILLEGAL_OPERAND.getErrorMessage());
        }
    }


    private static void isEmptyInput(String input) {
        if(input == null || input.length() == 0 || input.trim().length() == 0){
            throw new IllegalArgumentException(CustomErrorMessage.EMPTY_INPUT.getErrorMessage());
        }
    }
}
