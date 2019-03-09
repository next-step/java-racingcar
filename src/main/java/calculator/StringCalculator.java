package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("계산식을 입력하세요: ");
        String text = scanner.nextLine();

        if (StringUtils.isEmpty(text)) {
            throw new Exception("입력값을 다시 확인해주세요.");
        }

        System.out.println("계산 결과: " + calculate(text));
    }

    public static int calculate(String text) {

        String[] values = text.split(" ");
        List<String> expressions = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                nums.add(Integer.valueOf(values[i]));
            }

            if (i % 2 == 1) {
                expressions.add(values[i]);
            }
        }

        int numsSize = nums.size();
        int result = 0;

        for (String expr : expressions) {
            result = calculate(nums.get(0), nums.get(1), expr);

            nums = nums.subList(1, numsSize--);
            nums.set(0, result);
        }


        return result;
    }

    private static int calculate(int firstNum, int secondNum, String expression) {

        if (Objects.equals(expression, "+")) {
            return Calculator.add(firstNum, secondNum);
        }

        if (Objects.equals(expression, "-")) {
            return Calculator.substract(firstNum, secondNum);
        }

        if (Objects.equals(expression, "*")) {
            return Calculator.supply(firstNum, secondNum);
        }

        if (Objects.equals(expression, "/")) {
            return Calculator.divde(firstNum, secondNum);
        }

        return 0;
    }
}
