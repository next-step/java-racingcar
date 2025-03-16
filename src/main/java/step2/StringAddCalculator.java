package step2;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATORS = ",:";
    private static final String REGEX = "//(.)\n(.*)";

    public StringAddCalculator() {
        this.findCustomSeparator("\\#\n1#2#3");
    }

    private static String createRegex(String separators) {
        return "["+separators+"]";
    }

    public int[] splitNumbers(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new int[]{};
        }

        String regex = createRegex(DEFAULT_SEPARATORS);

        // [TODO] 강의에서 로또 미션 전까지는 stream 사용 없이 해보라는 조언
        return Arrays.stream(numbers.split(regex))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int addNumbersInArray(int[] numbers) {
        int sum = 0;

        if (numbers == null) {
            return sum;
        }

        for (int num:numbers) {
            sum += num;
        }

        return sum;
    }

    public String findCustomSeparator(String numbersWithCustomSeparator) {
        // e.g. //;\n1;2;3
        String[] lines = numbersWithCustomSeparator.split("\n"); // e.g. [//;, 1;2;3]
        String customSeparator = lines[0].substring(2);  // e.g. //;. ->  ;
        return customSeparator;
    }
}
