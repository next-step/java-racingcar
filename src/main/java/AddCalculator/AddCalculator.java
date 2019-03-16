package AddCalculator;

import spark.utils.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCalculator {
    public static int calculate(String str) {
        String[] strs = getSeparatedString(str);

        return Arrays.stream(strArrayToIntArr(strs)).sum();
    }

    private static String[] getSeparatedString(String str){
        if(StringUtils.isEmpty(str)){
            return new String[0];
        }

        String regex = "[:,]";

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if(m.find()){
            regex = m.group(1);
            str = m.group(2);
        }

        return str.split(regex);
    }

    private static int[] strArrayToIntArr(String[] strs){
        return Arrays.stream(strs)
            .mapToInt(AddCalculator::checkMinusNumber)
            .toArray();
    }

    private static int checkMinusNumber(String str) {
        int number = Integer.parseInt(str);
        if(number < 0){
            throw new RuntimeException();
        }
        return number;
    }
}
