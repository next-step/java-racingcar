import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimitedText {
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final Pattern CUSTOM_DELIMITER_EXTRACT_PATTERN = Pattern.compile("//(?<delimiter>.)\n(?<text>.*)");

    private final String delimiter;
    private final String text;

    private DelimitedText(String delimiter, String text) {
        this.delimiter = delimiter;
        this.text = text;
    }

    public static DelimitedText from(String text) {

        String delimiter = DEFAULT_DELIMITER;
        Matcher matcher = CUSTOM_DELIMITER_EXTRACT_PATTERN.matcher(text);

        if (matcher.find()) {
            delimiter = matcher.group("delimiter");
            delimiter = Pattern.quote(delimiter); // 추출한 문자가 정규식 표현으로 처리될 수 있으므로 escape 처리.

            text = matcher.group("text");
        }

        return new DelimitedText(delimiter, text);
    }

    public String delimiter() {
        return delimiter;
    }

    public String text() {
        return text;
    }

    public List<String> split() {
        return List.of(this.text.split(delimiter));
    }

}

