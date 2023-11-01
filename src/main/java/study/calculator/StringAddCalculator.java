package study.calculator;

import java.util.List;

public class StringAddCalculator {
    public static int splitAndSum(String origin) {
        if(origin == null || origin.isBlank()){
            return 0;
        }
        StringDelimiter stringDelimiter = new StringDelimiter(new Delimiter(origin));
        List<String> strings = stringDelimiter.filteredString(origin);
        return UserNumbers.from(strings).sum();
    }
}
