package step2;

public class StringAddCalculator {

    static SeparatorManager sm = new SeparatorManager();

    public static int splitAndSum(String str) {
        if (isBlank(str)) return 0;

        str = sm.findCustomSeparator(str);

        return sum(toInts(split(str)));
    }

    private static String[] split(String str) {
        return str.split(sm.getRegex());
    }

    private static boolean isBlank(String str) {
        return str == null || str.equals("");
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            if (number < 0) throw new RuntimeException();
            sum += number;
        }
        return sum;
    }

    private static int[] toInts(String[] strNumbers) {
        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            if (!isBlank(strNumbers[i])) numbers[i] = Integer.parseInt(strNumbers[i]);
        }
        return numbers;
    }
}
