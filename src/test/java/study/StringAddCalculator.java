package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (emptyOrNull(text)){
            return 0;
        }
        if (singleNum(text)) {
            return Integer.parseInt(text);
        }

        Matcher pattern = Pattern.compile("//(.)\n(.*)").matcher(text);

        int patternSum = 0;
        int notPatternSum =0 ;

        if (isPatternMatched(pattern)) {
            patternSum = sumPattern(pattern);
        } else {
            notPatternSum = sumAll(text);
        }
        if (patternSum >0){
            return  patternSum;
        }
        if (notPatternSum>0){
            return notPatternSum;
        }

        return -1;
    }

    private static boolean emptyOrNull(String text) {
        boolean isEmptyOrNull = false;
        if (text == null || text.isEmpty()) {
            isEmptyOrNull = true;
        }
        return isEmptyOrNull;
    }

    private static boolean singleNum(String text){
        boolean isSingleNum = false;
        if (text.length() == 1){
            isSingleNum = true;
        }
        return isSingleNum;
    }

    private static boolean isPatternMatched (Matcher pattern){
        boolean isPattern = false;
        if (pattern.find()){
            isPattern = true;
        }
        return  isPattern;

    }

    private static int sumPattern(Matcher pattern){
        int delimiternum = 1;
        int textnum = 2;
        String customDelimiter = pattern.group(delimiternum);
        String[] patternList = pattern.group(textnum).split(customDelimiter);
        int total = 0;
        for (String number : patternList) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new RuntimeException();
            }
            total += num;
        }
        return total;
    }
    private static int sumAll(String text) {
        String[] numbers = text.split(",|:");
        int total = 0;
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new RuntimeException();
            }
            total += num;
        }
        return total;
    }
}
