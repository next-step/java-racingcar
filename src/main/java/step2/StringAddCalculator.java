package step2;

public class StringAddCalculator {
    public static int splitAndSum(final String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }

        return sumParsedNumbers(new ParsedInput(input).getNumbers());
    }

    private static int sumParsedNumbers(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            int parsed = Integer.parseInt(number);
            if (parsed < 0) {
                throw new RuntimeException("음수는 입력 불가 합니다.");
            }

            total += parsed;
        }

        return total;
    }

}
