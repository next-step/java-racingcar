package calculator;

import java.util.Scanner;

public class RequestInput {

    static final Scanner sc = new Scanner(System.in);

    public String[] askUserForSuitableInput() {
        boolean isSuitable = false;
        String[] inputArray = {};
        while (!isSuitable) {
            // TODO : 입력 요청 출력
            String input = sc.next();
            inputArray = StringUtils.splitInput(input);
            isSuitable = ValidateUtils.validateInput(inputArray);
        }
        return inputArray;
    }


    public CalculationInfo convertToCalculationInfo(String[] inputArray, int index, int sum) {
        CalculationInfo calculationInfo = new CalculationInfo();
        calculationInfo.setDividend(sum);
        calculationInfo.setDivisor(Integer.getInteger(inputArray[index + 1]));
        calculationInfo.setOperator(Operator.valueOf(inputArray[index + 2]));
        return calculationInfo;
    }
}

// 2 + 3 * 4 / 2