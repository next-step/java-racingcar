import java.util.List;

public class StringAddCalculator {
    private static final List<Splitter> splitters = List.of(
        new CustomDelimiterSplitter(),
        new DefaultSplitter());


    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        return sum(split(input));
    }


    public static String[] split(String input) {
        for (Splitter splitter : splitters) {
            if (!splitter.isSupport(input)) {
                continue;
            }

            return splitter.split(input);
        }

        throw new RuntimeException("여기에 도달 할 수 없습니다.");
    }

    public static int sum(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            if (number < 0) {
                throw new RuntimeException("numbers는 음수를 허용하지 않습니다.");
            }
            sum += number;
        }
        return sum;
    }
}
