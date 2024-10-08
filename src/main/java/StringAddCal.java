import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCal {
    public static int splitAndSum(String input) throws RuntimeException {
        if (nullOrEmpty(input) == false) {
         return 0;
        }

        String[] split = customDelimeter(input);

        return calAllSum(split);
    }

    public static String[] customDelimeter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()) {
            String customDelimeter = m.group(1);
            String[] tokens = m.group(2).split(customDelimeter);
            return tokens;
        }
        return input.split(",|:");
    }

    public static int stringCastingInt(String input) {
        int i = Integer.parseInt(input);
        return i;
    }

    public static void negative(int number) {
        if(number < 0) {
            throw new RuntimeException();
        }
    }

    public static boolean nullOrEmpty(String input) {
        if(input == null || input.isEmpty()) {
            return false;
        }
        return true;
    }

    public static int calAllSum(String[] split) {
        int sum = 0;
        for(String s : split) {
            int num = stringCastingInt(s);
            negative(num);
            sum = sum + num;
        }
        return sum;
    }
}
