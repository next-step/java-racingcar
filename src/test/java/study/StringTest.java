package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    public void splitString(){
        String[] split = "1,2".split(",");
        assertThat(split).contains("1");
        assertThat(split).contains("2");
        assertThat(split).containsExactly("1","2");
    }
}
