package calculator;

import java.util.Scanner;

public class RequestInput {

    static final Scanner sc = new Scanner(System.in);

    public CalculationInfo askUserForSuitableInput() {
        //TODO: 유저에게 값 입력 요구하는 문구 출력
        String input = sc.next();
        String[] inputArray = StringUtils.splitInput(input);
        int index = 0;
        while (true) {
            if (index % 3 == 0) {
                //TODO: internalCalculator 호출
                //TODO: 예외처리 된 아이 한정으로 다시 값 입력 요구
            }
            CalculationInfo calculationInfo = convertToCalculationInfo(inputArray, index);
            index++;
        }
    }

    public CalculationInfo convertToCalculationInfo(String[] inputArray, int index) {
        CalculationInfo calculationInfo = new CalculationInfo();
        calculationInfo.setDividend(Integer.getInteger(inputArray[index]));
        calculationInfo.setDivisor(Integer.getInteger(inputArray[index + 1]));
        try {
            calculationInfo.setOperator(Operator.valueOf(inputArray[index + 2]));
        } catch (java.lang.IllegalArgumentException e) {
            calculationInfo.setResumeInputRequest(true);
        }
        return calculationInfo;
    }
}
