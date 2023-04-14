package step2;

import java.util.Arrays;

public class StringCalculator {
    public int sum(String input) throws RuntimeException {
        if(Util.isNullOrBlank(input)) {
            input = "0";
        }
        String[] nums = getNumbers(input);
        Util.hasMinusNumber(nums);
        return sumArray(nums);
    }

    private String[] getNumbers(String input) {
        if (Util.hasCustomDelimiter(input)) {
            return Util.splitCustomDelimiter(input);
        }
        return Util.split(input);
    }

    private int sumArray(String[] nums) {
        return Arrays.stream(nums)
                .map(num -> Util.isNullOrBlank(num) ? 0 : Util.convertInput(num))
                .reduce(0, Integer::sum);
    }


}
