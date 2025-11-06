package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


    public static int splitAndSum(String text){
        if(isEmptyOrNull(text)){
            return 0;
        }

        return sum(toInt(split(text)));
    }
    private static boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
    private static int[] toInt(String[] strings) {
        int[] ints = new int[strings.length];
        for(int i = 0; i < strings.length; i++){
            checkNoNum(strings[i]);

            ints[i] = checkMinusNum(Integer.parseInt(strings[i]));
        }
        return ints;
    }
    private static void checkNoNum(String str) {
        if(!str.matches("-?\\d+")){
            throw new RuntimeException("숫자가 아닌 문자입니다.");
        }
    }
    private static int checkMinusNum(int num) {
        if (num < 0){
            throw new RuntimeException("음수일 수 없습니다.");
        }
        return num;
    }

    private static String[] split(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String delimiter = m.group(1);
            String str = m.group(2);

            return str.split(delimiter);
        }
        return s.split(",|:");
    }
}
