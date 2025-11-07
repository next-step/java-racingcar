package study;

public class StringAddCalculator {
    
    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }
        int result = 0;
        String[] textNums = text.split(",");
        for(String textNum: textNums) {
            result += toInt(textNum);
        }
        return result;
    }
    
    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
    
    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
