package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String INPUT_ERR = "입력한 계산식을 다시 확인해주세요.";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("계산식을 입력하세요: ");
        String text = scanner.nextLine();

        if (StringUtils.isEmpty(text)) {
            throw new Exception(INPUT_ERR);
        }

        if (!checkCalculatorText(text)) {
            throw new Exception(INPUT_ERR);
        }

        System.out.println("계산 결과: " + calculate(text));
    }

    public static boolean checkCalculatorText(String text) {
        Pattern simpleCalcPattern = Pattern.compile("^(\\d+)((\\s[+\\-*/]\\s)(\\d+))+$");
        Matcher simpleCalcMatcher = simpleCalcPattern.matcher(text);

        return simpleCalcMatcher.matches();
    }

    public static List<String> extractOperators(String text) {
        Pattern simplePattern = Pattern.compile("[+\\-*/]");
        Matcher simpleMatcher = simplePattern.matcher(text);

        List<String> operators = new ArrayList<>();

        while (simpleMatcher.find()) {
            operators.add(simpleMatcher.group());
        }

        return operators;
    }

    public static List<Integer> extractOperands(String text) {
        Pattern simplePattern = Pattern.compile("\\d+");
        Matcher simpleMatcher = simplePattern.matcher(text);

        List<Integer> operands = new ArrayList<>();

        while (simpleMatcher.find()) {
            operands.add(Integer.parseInt(simpleMatcher.group()));
        }

        return operands;
    }

    public static int calculate(String text) throws Exception {

        int result = 0;

        List<String> operators = extractOperators(text);
        List<Integer> operands = extractOperands(text);

        int j = 0;
        for (int i = 0; i < operands.size() - 1; i++) {
            result = calculate(operands.get(i), operands.get(i+1), operators.get(j++));

            operands.set(i, 0);
            operands.set(i+1, result);
        }

        return result;
    }

    private static int calculate(int firstNum, int secondNum, String operatorLooks) throws Exception {
        Operator calc = Operator.looksOf(operatorLooks);

        return calc.calculate(firstNum, secondNum);
    }
}
