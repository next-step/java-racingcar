package study.nextstep;

import java.util.Arrays;

public class StringAddCalculator {
    private static final String prefix = "//";
    private static final String suffix = "\n";

    public static int splitAndSum(String example) {
        if(example.isEmpty()) {
            return 0;
        }

        return Arrays.stream(numberArray(example))
                .map(str -> {
                    if(!Character.isDigit(str.charAt(0))) {
                        throw new RuntimeException();
                    }

                    if(Integer.parseInt(str) < 0) {
                        throw new RuntimeException();
                    }

                    return Integer.parseInt(str);
                }).reduce(0, Integer::sum);
    }

    private static String[] numberArray(String example) {
        StringBuilder separators = new StringBuilder("[,|:");

        if(example.contains(prefix) && example.contains(suffix)) {
            separators.append("|")
                    .append(example, example.indexOf(prefix) + prefix.length(), example.indexOf(suffix));
            example = example.substring(example.indexOf(suffix)).trim();
        }
        separators.append("]");

        return example.split(separators.toString());
    }
}
