package step2;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (text.contains(",")) {
            String[] nums = text.split(",");
            return sum(nums);
        }

        return Integer.parseInt(text);
    }

    private static int sum(String[] nums) {
        int result = 0;
        for (String num : nums) {
            result += Integer.parseInt(num);
        }

        return result;
    }
}
