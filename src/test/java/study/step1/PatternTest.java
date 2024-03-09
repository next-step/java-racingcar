package study.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    @DisplayName("//와 \n 사이에 커스텀 구분자를 식별할 수 있다.")
    @Test
    void compile() {
        Pattern pattern = Pattern.compile("^//.\n");
        Matcher matcher = pattern.matcher("//a\n");
        boolean matches = matcher.matches();
        Assertions.assertThat(matches).isTrue();
    }
}
