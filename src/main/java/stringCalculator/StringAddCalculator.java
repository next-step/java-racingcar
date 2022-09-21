package stringCalculator;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

@Slf4j
public class StringAddCalculator {

    static Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {

        if(isNullOrEmpty(text)){
            return 0;
        };

        if(isNumber(text)){
            return Integer.parseInt(text);
        }

        if(isSplitCommaOrColon(text)){
            return Arrays.stream(text.split(",|:")).mapToInt(Integer::parseInt).sum();
        }

        return splitCustomDelimiterAndAdd(text);
    }

    private static boolean isSplitCustom(String text) {
        return customDelimiterPattern.matcher(text).find();
    }

    private static int splitCustomDelimiterAndAdd(String text) {

        Matcher matcher = customDelimiterPattern.matcher(text);

        if(!matcher.find()){
            throw new NoSuchElementException();
        };

        String customDelimiter = matcher.group(1);
        String[] tokens= matcher.group(2).split(customDelimiter);

        Arrays.stream(tokens).mapToInt(Integer::parseInt).filter(n->n<0).findAny().ifPresent(a->{throw new RuntimeException();});
        return Arrays.stream(tokens).mapToInt(Integer::parseInt).reduce(0, Integer::sum);
    }


    private static boolean isSplitCommaOrColon(String text) {

        if(text.matches("^[0-9](.*)")){
          return true;
        }

        return false;
    }

    private static boolean isNullOrEmpty(String text) {
        if(text == null) {
            return true;
        }
        if(text.isEmpty()){
            return true;
        }
        return false;
    }

    private static boolean isNumber(String text) {
        return text.chars().allMatch(Character::isDigit);
    }
}
