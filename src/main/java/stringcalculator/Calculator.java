package stringcalculator;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.regex.Pattern;

/**
 * Created By mand2 on 2020-11-03.
 * 계산기: 입력값 확인, 결과값 반환.
 */
public class Calculator {

    private String input;

    public Calculator(String input) {
        if (null == input || input.isEmpty() || "".equals(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        this.input = input;
    }

    public int calculate() {
        String[] arr = this.seperator();
        int length = arr.length;
        if (length % 2 == 0) {
            throw new IllegalArgumentException("입력한 계산식이 부호로 끝났습니다.");
        }

        int result = setCalculator(arr[0]);
        for (int j = 2; j < length; j += 2) {
            inputChecker(arr[j]);
            result = Operator.calculate(result, arr[j-1], NumberUtils.toInt(arr[j]));
        }
        return result;
    }

    public int setCalculator(String startNumber) {
        inputChecker(startNumber);
        return NumberUtils.toInt(startNumber);
    }

    public String[] seperator() {
        return this.input.split(" ");
    }

    public boolean inputChecker(String str) {
        boolean result = Pattern.matches("^([0-9]+)$", str);
        if (!result) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return true;
    }
}
