package study;

public class StringAddCalculator {
    
    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }
        return Integer.parseInt(text);
    }
    
    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
