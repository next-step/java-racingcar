package step2;

public class StringAddCalculator {

    private static String[] defaultSeparators = {",", ":"};

    public static int splitAndSum(String str) {
        if (isBlank(str)) return 0;

        if (containsDefaultSeparator(str)) {
            return sum(toInts(splitByDefaultSeparator(str)));
        }

        return Integer.parseInt(str);
    }

    private static String[] splitByDefaultSeparator(String str) {
        return str.split("[,:]");
    }

    private static boolean isBlank(String str) {
        return str == null || str.equals("");
    }

    private static boolean containsDefaultSeparator(String str) {
        for (String defaultSeparator : defaultSeparators) {
            if (str.contains(defaultSeparator)) return true;
        }

        return false;
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
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
