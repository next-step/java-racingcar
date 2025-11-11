package calculator;

import java.util.Arrays;
import java.util.List;

public class ParsedInput {

    private final String delimiter;
    private final String content;

    public ParsedInput(String delimiter, String content) {
        this.delimiter = delimiter;
        this.content = content;
    }

    public List<String> split() {
        return Arrays.stream(content.split(delimiter))
                .toList();
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getContent() {
        return content;
    }
}
