package step2;

public final class StringUtil {
    public static boolean isNumber(String str) {
        if(str.isEmpty()) return false;
        return str.matches("(^[0-9]*.$)");
    }

    public static String[] doSplit(String input, String key) {
        checkCanSplit(input, key);
        try {
            return input.split(key);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("check the text you entered, input String :"+ input+
                    " split keyword: "+key);
        } catch (NullPointerException e) {
            throw new NullPointerException("check the text you entered, input String :"+ input+
                    " split keyword: "+key);
        }
    }

    private static void checkCanSplit(String input, String key) {
        if (input.length() < key.length())
            throw new IllegalArgumentException("Can't split short String as long String , input String :" + input +
                    " split keyword: " + key);
        if (input.isEmpty() || key.isEmpty())
            throw new IllegalArgumentException("you entered empty word, input:" + input +
                    " split keyword: " + key);
    }

    public static double convertStringToDouble(String number) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Can't convert Double value: " + number);
        }
    }
}
