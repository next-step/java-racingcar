package racing_car.step2;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    public static int splitAndSum(String formula) throws UnsupportedOperationException {
        if (StringUtils.isBlank(formula)) {
            return 0;
        }
        
        return sum(getSplit(formula));
    }
    
    private static String[] getSplit(String formula) {
        Matcher matcher = Pattern.compile("//(.)\\n(.+)").matcher(formula);
        if (matcher.matches()) {
            String delimer = matcher.group(1);
            return matcher.group(2).split("[" + delimer + "]");
        }
        
        return formula.split("[,:]");
    }
    
    private static int sum(String[] split) throws UnsupportedOperationException {
        return Stream.of(split)
                .mapToInt(Integer::parseInt)
                .map(StringAddCalculator::negativeCheck)
                .sum();
    }
    
    private static int negativeCheck(int element) throws UnsupportedOperationException {
        if (element < 0) {
            throw new UnsupportedOperationException("음수는 입력할 수 없습니다.");
        }
        return element;
    }
}
