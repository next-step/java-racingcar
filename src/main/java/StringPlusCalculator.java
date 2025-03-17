import java.util.Arrays;

public class StringPlusCalculator {

    private static String SEPERATOR_REGEX = "//(.*?)\n";

    public int calculate(String input) {
        if (input == null) {
            return 0;
        }

        StringSplitter splitter = StringSplitter.from(input);
        String[] splited = splitter.getInputString().split("[" + splitter.getSeparator() + "]");

        return Arrays.stream(splited)
                     .filter(s -> !s.isEmpty())
                     .mapToInt(Integer::parseInt)
                     .filter(it -> it > 0)
                     .sum();
    }
}
