package utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String sampleInput) {
        if(sampleInput == null){
            return true;
        }
        sampleInput = sampleInput.trim();
        return sampleInput.equals("");
    }
}
