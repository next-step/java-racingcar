package study;

public class StringAddCalculator {
    
    public static int splitAndSum(String text) {
        return isNullOrEmpty(text) ? 0 : adder(stringsToInts(splitText(text)));
    }
    
    private static int adder(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result += num;
        }
        return result;
    }
    
    private static String[] splitText(String text) {
        return text.split(",|:");
    }
    
    private static int[] stringsToInts(String[] texts) {
        int length = texts.length;
        int[] ints = new int[length];
        for(int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(texts[i]);
        }
        return ints;
    }
    
    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
