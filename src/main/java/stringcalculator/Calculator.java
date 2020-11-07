package stringcalculator;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Created By mand2 on 2020-11-03.
 * 계산기: 입력값 확인, 결과값 반환.
 */
public class Calculator {

    private String input;

    public Calculator(String input) {
        if (Objects.isNull(input) || input.isEmpty() || "".equals(input)) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        this.input = input;
    }

    public int calculate() {
        String[] arr = this.separator();
        int length = arr.length;
        if (length % 2 == 0) {
            throw new IllegalArgumentException("입력한 계산식이 부호로 끝났습니다.");
        }

        int result = 0;
        for (int i = 0; i < length; i += 2) {
            inputChecker(arr[i]);
            result = i == 0
                    ? Operator.calculate(result, "+", NumberUtils.toInt(arr[i]))
                    : Operator.calculate(result, arr[i-1], NumberUtils.toInt(arr[i]));
        }
        return result;
    }

    public String[] separator() {
        return this.input.split(" ");
    }

    public void inputChecker(String str) {
        boolean result = Pattern.matches("^([0-9]+)$", str);
        if (!result) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
