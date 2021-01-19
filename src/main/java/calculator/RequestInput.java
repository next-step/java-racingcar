package calculator;

import java.util.Scanner;

public class RequestInput {

    static final Scanner sc = new Scanner(System.in);

    public String[] askUserForSuitableInput() {
        String[] inputArray = {};
        do {
            PrintUtils.printInputRequest();
            String input = sc.nextLine();
            inputArray = StringUtils.splitInput(input);
        } while (!ValidateUtils.validateInput(inputArray));
        return inputArray;
    }

    public CalculationInfo convertToCalculationInfo(String[] inputArray, int index, Integer total) {
        CalculationInfo calculationInfo = new CalculationInfo();
        calculationInfo.setDividend(total);
        calculationInfo.setDivisor(Integer.parseInt(inputArray[index + 2]));
        calculationInfo.setOperator(Operator.validateOperator(inputArray[index + 1]));
        return calculationInfo;
    }
}

// 2 + 3 * 4 / 2
