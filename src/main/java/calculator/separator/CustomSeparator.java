package calculator.separator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSeparator implements Separator {

    private final String CUSTOM_REGEX = "//(.+)\n(.*)";

    @Override
    public boolean matchable(String text) {
        return getMatcher(text).find();
    }

    private Matcher getMatcher(String text) {
        return Pattern.compile(CUSTOM_REGEX).matcher(text);
    }

    @Override
    public List<String> separate(String text) {
        // 코드 중복이 발생한다!
        Matcher matcher = getMatcher(text);
        if (matcher.find()) {
            return createSeparatedTextWithCustomRegex(matcher);
        }
        throw new IllegalStateException();
    }

    private List<String> createSeparatedTextWithCustomRegex(Matcher matcher) {
        return Arrays.asList(createTarget(matcher)
                .split(Pattern.quote(createDelimiter(matcher))));
    }

    private String createTarget(Matcher matcher) {
        return matcher.group(2);
    }

    private String createDelimiter(Matcher matcher) {
        return matcher.group(1);
    }
}
