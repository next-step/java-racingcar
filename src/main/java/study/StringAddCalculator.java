package study;

public class StringAddCalculator {
    
    public static int splitAndSum(String text) {
        return isNullOrEmpty(text) ? 0 : toInt(text);
    }
    
    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
    
    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
