package calculator;

public class StringTokenizer {
    private static int[] customSepartorIdx = null;
    private static final String BASIC_REGEX = ",|:";

    public static void locateCustomSeperator(String text) {
        int customSeparatorStartIdx = text.indexOf("//") + 2;
        int customSeparatorEndIdx = text.indexOf("\n");
        if (customSeparatorStartIdx == -1 || customSeparatorEndIdx == -1 || customSeparatorStartIdx >= customSeparatorEndIdx)
            return;
        customSepartorIdx = new int[]{customSeparatorStartIdx, customSeparatorEndIdx};
    }

    public static String makeRegex(String text) {
        StringBuilder regex = new StringBuilder().append(BASIC_REGEX);
        locateCustomSeperator(text);
        if (customSepartorIdx == null)
            return regex.toString();
        String subText = text.substring(customSepartorIdx[0], customSepartorIdx[1]);
        subText.chars().forEach(ch -> regex.append('|').append((char) ch));
        return regex.toString();
    }

    public static String[] tokenString(String text) {
        locateCustomSeperator(text);
        String regex = makeRegex(text);
        if (customSepartorIdx != null) {
            text = text.substring(customSepartorIdx[1] + 1);
        }
        return text.split(regex);
    }

}
