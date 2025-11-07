package study;

public class StringAddCalculator {
    
    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }
        int result = 0;
        return result;
    }
    
    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
