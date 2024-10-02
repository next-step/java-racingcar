package stringadder.delimiter;

import java.util.List;

public interface NumberParser {
    List<String> split(String text);

    boolean hasDelimiter(String text);
}
