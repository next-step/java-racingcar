import org.apache.commons.lang3.StringUtils;

public class Calculator {
    static int calculate(String input) {
        String[] inputArray = extractInputStr(input);

        int result = Integer.parseInt(inputArray[0]);
        int numberOfOperation = inputArray.length / 2;

        for (int i = 0; i<numberOfOperation; i++) {
            String op = inputArray[i*2 + 1];
            int newNum = Integer.parseInt(inputArray[i*2 + 2]);
            result = calculateEach(result, op, newNum);
        }

        return result;
    }

    private static String[] extractInputStr(String input) {
        if (StringUtils.isBlank(input)) {
            throw new RuntimeException("입력 오류 발생");
        }
        return input.split(" ");
    }

    private static int calculateEach(int oldNum, String op, int newNum) {
        if (StringUtils.equals(op, "+")) {
            return oldNum + newNum;
        }
        if (StringUtils.equals(op, "-")) {
            return oldNum - newNum;
        }
        if (StringUtils.equals(op, "*")) {
            return oldNum * newNum;
        }
        if (StringUtils.equals(op, "/")) {
            return oldNum / newNum;
        }

        throw new RuntimeException("부호 오류 발생");
    }

}
