package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.ConstantCollection.*;

public class StringCalculator {


    static int calculator(String input)  {

        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException();
        }

        // 띄우쓰기를 우선 제거
        String trimString = input.trim();
        int result = 0;
        // 피연산자를 저장해주는 리스트
        List<Integer> operands = new ArrayList<>();
        // 연산자를 저장해주는 리스트
        List<String> operators = new ArrayList<>();
        // operand를 리스트에 저장하기 위한 임시 StringBuffer
        StringBuilder tempForOperand = new StringBuilder();

        String [] splitTrimString = trimString.split("");

        for (int i = 0; i < splitTrimString.length; i++) {

            tempForOperand.append(splitTrimString[i]);

            if (("+").equals(splitTrimString[i]) || ("*").equals(splitTrimString[i]) ||
                    ("-").equals(splitTrimString[i]) || ("/").equals(splitTrimString[i])) {
                isMeetOperator(tempForOperand, operands, operators);
            }

            // 마지막 문자열의 경우 연산자 추가 없이 값만 추가해준다.
            if (i == splitTrimString.length - 1) {
                operands.add(Integer.parseInt(String.valueOf(tempForOperand)));
            }

            //2개의 오퍼랜드와 한개의 오퍼레이터를 넘긴다.
            if (operands.size() == IN_TWO_OPERAND) {
                int value = calculator(operands.get(0), operands.get(1), operators.get(0));
                result = value;
                operands.clear();
                operators.remove(0);
                operands.add(value);
            }
        }

        return result;
    }

    public static void isMeetOperator(StringBuilder tempForOperand, List<Integer> operands, List<String> operators) {
        String temp = tempForOperand.toString();
        temp = temp.substring(0, tempForOperand.length() - 1);

        operands.add(Integer.parseInt(temp));
        operators.add(String.valueOf(temp.charAt(temp.length() - 1)));

        tempForOperand.setLength(0);
    }

    public static int calculator(int firstOperand, int secondOperand, String operator) {

        int result = 0;
        if (operator.equals("-")) {
             return firstOperand - secondOperand;
        }

        if (operator.equals("+")) {
            return firstOperand + secondOperand;
        }

        if (operator.equals("*")) {
            return  firstOperand * secondOperand;
        }

        if (operator.equals("/")) {
            // 분모가 0인 경우 에러처리
            if (secondOperand == MINIMUM_DENOMINATOR_VALUE) {
                throw new IllegalArgumentException();
            }

            return firstOperand / secondOperand;
        }
        return result;
    }

    public static String inputConsole()  {
        System.out.println("계산하고자하는 문자열을 입력하세요");
        System.out.print(" : ");

        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        if (value.length() < MINIMUM_INVALID_INPUT) {
            throw new IllegalArgumentException();
        }

        return value;
    }
}
