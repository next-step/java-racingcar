package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split() {
        //given, when
        String[] split = "1,2".split(",");

        //then
        assertThat(split).contains("1");
        assertThat(split).contains("2");
        assertThat(split.length).isEqualTo(2);

        assertThat(split).containsExactly("1", "2");
        assertThat(split).containsAnyOf("1");
        assertThat(split).doesNotContain("3");
        assertThat(split).endsWith("1", "2");
    }

    @Test
    void substring(){
        //when
        String substring = "(1,2)".substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    void substring2(){
        //when
        String substring = "(1,2,3)".substring(1, 6);
        assertThat(substring).isEqualTo("1,2,3");
    }
}
