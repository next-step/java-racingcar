package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    void split(){
        String[] values = "1,2".split(",");
        assertThat(values).hasSize(2);
        assertThat(values).containsExactly("1","2");

        values = "1".split(",");
        assertThat(values).hasSize(1);
        assertThat(values).containsExactly("1");
    }

    @Test
    void subString() {
        String value = "(1,2)";
        assertThat(value.substring(1,value.length()-1)).contains("1,2");
    }

    @Test
    void charAt_특정_위치_문자() {
        String value = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    throw new StringIndexOutOfBoundsException("error!!");
                }).withMessageMatching("2,2");

    }
}
