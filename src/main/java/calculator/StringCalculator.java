package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int calculate(String input) {

        String[] inputArr = checkInputValueAndReturnSplitArray(input, " ");

        List<String> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        operands.add(inputArr[0]);

        //수식 분리
        for (int i = 1; i < inputArr.length ; i+=2) {
            operators.add(inputArr[i]);
            operands.add(inputArr[i+1]);
        }

        checkOperators(operators);


        int result = Integer.parseInt(operands.get(0)); //첫번째 피연산자로 시작
        int operationIndex = 0; //연산자 시작 index
        int scondOperandIndex = 1; //두번째 피연산자 index

        do {

            //result에 앞의 연산 결과를 대입하며 반복문으로 연산식을 줄여가며 결과를 구합니다.
            //ex) (result = 3)     3 + 3 / 2 * 2
            //    (result = 3 + 3) 6 / 2 * 2
            //    (result = 6 / 2) 3 * 2
            //    (result = 3 * 2) 6
            result = doFourOperate(operators.get(operationIndex++),
                                        result,
                                        Integer.parseInt(operands.get(scondOperandIndex++)));

        } while (operationIndex < operators.size());//validation이 끝났기 때문에 연산자의 위치만으로 loop 조건을 지정할 수 있습니다.


        return result;
    }

    /**
     * 4칙연산 메소드
     * @param operator 연산자
     * @param firstOperand 첫번째 피연산자
     * @param secondOperand 두번째 피연산자
     * @return 연산 결과
     */
    private static int doFourOperate(String operator, int firstOperand, int secondOperand) {

        if ("+".equals(operator))
            return firstOperand + secondOperand;
        if ("-".equals(operator))
            return firstOperand - secondOperand;
        if ("*".equals(operator))
            return firstOperand * secondOperand;
        if ("/".equals(operator))
            return firstOperand / secondOperand;

        //이미 validation 해주었기 때문에 return 0;이 될리가 없음..
        return 0;
    }

    /**
     * input의 길이와 null 또는 공백을 체크하고 split으로 나눈 array를 반환해주는 메소드
     *
     * @param input 입력한 수식
     * @param separator String.split(parameter)의 parameter
     * @return String[] split 된 array
     */
    private static String[] checkInputValueAndReturnSplitArray(String input, String separator) {

        if (input == null || input.trim().equals("") || input.length() < 5)
            throw new IllegalArgumentException("잘못된 수식입니다 : " + input);

        String[] inputArr = input.split(separator);
        int length = inputArr.length;

        if (length < 3 || (length % 2) != 1)
            throw new IllegalArgumentException("잘못된 수식입니다 : " + input);

        return inputArr;
    }

    /**
     * 연산자를 검증하는 메소드
     * @param operators 연산자 arrayList
     *
     */
    private static void checkOperators(List<String> operators) {

        for (String operator : operators) {
            if (!checkOperator(operator))
                throw new IllegalArgumentException("연산자를 제대로 입력해주세요.");
        }
    }

    /**
     * 4칙연산이 맞는지 체크하는 메소드
     * @param operator 연산자
     * @return boolean 4칙연산 여부
     */
    private static boolean checkOperator(String operator) {

        return "+".equals(operator) ||
                "-".equals(operator) ||
                "*".equals(operator) ||
                "/".equals(operator);
    }
}
