package racing_car.step2;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Stream;

public class StringAddCalculator {
    public static int splitAndSum(String formula) {
        if (StringUtils.isBlank(formula)) {
            return 0;
        }
        
        String[] split = formula.split(",");
        if (split.length == 1) {
            return 1;
        }
        
        return sum(split);
    }
    
    private static int sum(String[] split) {
        return Stream.of(split)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
