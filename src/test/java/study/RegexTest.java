package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    void 정규식_테스트() {
        String regex = "([,:])|(//(.+)\n(.*))";
//        String regex = "//(.)\n(.*)";
        String text = "//avx\n";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        if (matcher.find()) {
            String group = matcher.group(1);
            System.out.println("group = " + group);
        }
    }
}
