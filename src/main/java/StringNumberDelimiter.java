import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringNumberDelimiter {
    private static Set<String> delimiterSet = new HashSet<>();
    private static Pattern pattern = Pattern.compile("^//.\n.*");

    static {
        delimiterSet.add(",");
        delimiterSet.add(":");
    }

    public static String getDelimiter(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return String.valueOf(input.charAt(2));
        }

        return delimiterSet.stream()
                .filter(delimiter -> input.contains(delimiter))
                .findFirst()
                .get();

    }

    public static boolean checkCustomDelimiter(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
