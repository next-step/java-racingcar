package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String SEPARATE_EXPRESSION_RULE = " ";


    private InputParser() {
    }

    public static List<String> getCalculationMaterial(String inputData) {
        validateInputDataIsEmpty(inputData);
        String[] separateData = inputData.split(SEPARATE_EXPRESSION_RULE);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < separateData.length; i++) {
            findOperatorType(separateData, i);
            result.add(separateData[i]);
        }
        return result;
    }

    private static void findOperatorType(String[] separateData, int index) {
        if (index % 2 == 1) {
            validateIsCorrectOperatorType(separateData[index]);
        }
    }

    private static void validateInputDataIsEmpty(String inputData) {
        if (isNullOrEmpty(inputData) || isBlank(inputData)) {
            throw new IllegalArgumentException("입력값이 비어있습니다");
        }
    }

    private static boolean isNullOrEmpty(String inputData) {
        return inputData == null || inputData.length() == 0;
    }

    private static boolean isBlank(String inputData) {
        return inputData.trim().length() == 0;
    }


    private static void validateIsCorrectOperatorType(String operatorType) {
        if (!Operator.isContainOperator(operatorType)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
        }
    }

}
