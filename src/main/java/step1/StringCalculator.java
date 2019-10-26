package step1;

import java.util.ArrayList;

import static step1.Utils.ValidationUtils.isBlankThrowException;
import static step1.Utils.ValidationUtils.isNotNumericThrowException;

public class StringCalculator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String SPACE_DELIMITER = " ";

    private ArrayList<String> operands;
    private ArrayList<Integer> operates;
    private int result;

    StringCalculator(){
        result = 0;
        operands = new ArrayList<>();
        operates = new ArrayList<>();
    }

    public int calculate(String input) {
        isBlankThrowException(input);
        String[] splitedStringArray = splitStringBySpace(input);

        iterateClassification(splitedStringArray);
        iterateCalculation();
        return result;
    }

    public String[] splitStringBySpace(String input){
        return input.split(SPACE_DELIMITER);
    }

    public void iterateClassification(String[] splitedStringArray) {
        for(String splitedString: splitedStringArray) {
            classificateOperandAndOperate(splitedString);
        }
    }

    public void classificateOperandAndOperate(String splitedString) {
        switch(splitedString) {
            case PLUS:
            case MINUS:
            case MULTIPLY:
            case DIVIDE:
                operands.add(splitedString);
                break;
            default:
                isNotNumericThrowException(splitedString);
                operates.add(Integer.parseInt(splitedString));
                break;
        }
    }

    public void iterateCalculation() {
        for(int i=0; i < operands.size(); i++) {
            doCalculation(i, operands.get(i));
        }
    }

    public void doCalculation(int index, String operand) {
        int a, b;

        a = result;
        b = operates.get(index+1);
        if(index == 0){
            a = operates.get(index);
        }

        switch(operand) {
            case PLUS:
                add(a, b);
                break;
            case MINUS:
                subtract(a, b);
                break;
            case MULTIPLY:
                multiply(a, b);
                break;
            case DIVIDE:
                divide(a, b);
                break;
            default:
                break;
        }
    }

    public void add(int a, int b) {
        result = a + b;
    }

    public void subtract(int a, int b) {
        result = a - b;
    }
    public void multiply(int a, int b) {
        result = a * b;
    }

    public void divide(int a, int b) {
        try {
            result = a / b;
        } catch(ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
