package study;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        String[] split = split(text);
        return sum(split);
    }

    public static String[] split(String text){
        return text.split(",");
    }

    public static int sum(String[] textArray){
        int result = 0;
        for (String text : textArray) {
            result += Integer.parseInt(text);
        }
        return result;
    }


}
