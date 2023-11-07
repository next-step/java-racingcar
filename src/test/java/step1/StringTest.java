package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("Split test")
    public void splitTest(){
        String[] actual1 = "1,2".split(",");
        String[] actual2 = "1".split(",");
        assertThat(actual1).contains("1", "2");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    @DisplayName("Substring test")
    public void substringTest(){
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("1. charAt() 메소드를 통한 특정 문자 위치를 가져오는 테스트\n" +
            "2. 범위를 벗어난 값을 가져와 StringIndexOutOfBoundsException 테스트")
    public void charAtTest(){
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');

        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
