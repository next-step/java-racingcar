package step2;

public class Calculator {
    public static int splitCalculator(String input) {
        int result = 0;
        if(input == null || input.isBlank()) {
            result = 0;
        } else if (isContainCommaOrColon(input)) {
            String[] strs = input.split(",|:");
            result = getSum(strs);
        } else if (isCustomDelimiter(input)) {
            String[] strs = input.substring(5).split(input.substring(2,3));
            result = getSum(strs);
        }
        return result;
    }

    private static int getSum(String[] strs) {
        int result = 0;

        for(String s : strs) {
            int num = changeStringToNum(s);
            result += num;
        }
        return result;
    }

    private static boolean isCustomDelimiter(String input) {
        return input.contains("//") && input.contains("\\n");
    }

    private static boolean isContainCommaOrColon(String input) {
        return input.contains(",") || input.contains(":");
    }

    private static int changeStringToNum(String input) {
        try {
            int num = Integer.parseInt(input);
            if(num < 0) {
                throw new RuntimeException();
            }
            return num;
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }
}
