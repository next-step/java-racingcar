package step2.delimiter;

import java.util.List;

public interface NumberParser {
    List<String> splitFrom(String text);

    boolean isContainsDelimiter(String text);
}
