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

    public static StringDelimiter getDelimiter(String input) {
        if (input == null || input.isBlank()) {
            return StringDelimiter.empty();
        }

        if (containCustomDelimiter(input)) {
            return new StringDelimiter(String.valueOf(input.charAt(2)), true);
        }

        return new StringDelimiter(createDelimiter(input), false);
    }

    private static boolean containCustomDelimiter(String input) {
        if (input == null) {
            return false;
        }

        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static String createDelimiter(String input) {
        String filterDelimiter = delimiterSet.stream()
                .filter(delimiter -> input.contains(delimiter))
                .findFirst()
                .get();
        return filterDelimiter;
    }

    static class StringDelimiter {
        private final String delimiter;
        private final boolean isCustomDelimiter;

        public StringDelimiter(String delimiter, boolean isCustomDelimiter) {
            this.delimiter = delimiter;
            this.isCustomDelimiter = isCustomDelimiter;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public static StringDelimiter empty() {
            return new StringDelimiter("", false);
        }

        public boolean isCustomDelimiter() {
            return this.isCustomDelimiter;
        }
    }
}
