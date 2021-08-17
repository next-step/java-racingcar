package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StudyTest {
    @Test
    void splitTest() {
       assertThat("1,2".split(",")).contains("1");
    }

    @Test
    @DisplayName("")
    void substringTest() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    void charAtTest() {
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    void charAtTestException() {
        assertThatThrownBy(()->{
            "abc".charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
