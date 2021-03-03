package step_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;

@DisplayName("String Class Edu Test")
public class StringAssertionTest {

    @DisplayName("Split Test")
    @Test
    void splitAssertion() {
        final String primarySampleVariable = "1,2";
        final String secondarySampleVariable= "1,";
        assertThat(primarySampleVariable.split(","))
                .contains("1")
                .contains("2")
                .containsExactly("1","2");
        assertThat(secondarySampleVariable.split(","))
                .containsOnly("1");
    }

    @DisplayName("Substring Test")
    @Test
    void substringAssertion() {
        String mutableSampleVariable = "(1,2)";
        final Matcher matcher = Pattern.compile("\\((.*?)\\)").matcher(mutableSampleVariable);
        if (matcher.find()) {
            mutableSampleVariable = mutableSampleVariable.substring(matcher.start() + 1, matcher.end() - 1);
        }
        assertThat(mutableSampleVariable).isEqualTo("1,2");
    }

    @DisplayName("Exception Thrown Test")
    @Test
    void charAtAssertion() {
        final String sampleVariable = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    try {
                        sampleVariable.charAt(4);
                    } catch (StringIndexOutOfBoundsException exception) {
                        throw new StringIndexOutOfBoundsException("boom!");
                    }
                })
                .withMessage("%s!", "boom")
                .withMessageContaining("boom")
                .withNoCause();
    }
}
