package step2;


import java.util.List;

public class StringAddCalculator {

    private final static NumberSeparator separator = new NumberSeparator();


    public static int splitAndSum(String o) {
        List<Integer> splitNumber = separator.separate(o);
        return sum(splitNumber);
    }

    private static int sum(List<Integer> splitNumber) {
        return splitNumber.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
