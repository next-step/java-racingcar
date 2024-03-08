import java.util.HashSet;
import java.util.Set;

class StringNumberDelimiter {
    private static Set<String> delimiterSet = new HashSet<>();

    static {
        delimiterSet.add(",");
        delimiterSet.add(":");
    }

    public static String getDelimiter(String input) {
        if (input == null || input.isBlank()) {
            return "";
        }

        return delimiterSet.stream()
                .filter(delimiter -> input.contains(delimiter))
                .findFirst()
                .get();

    }
}
