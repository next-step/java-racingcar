package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void splitOneAndTwo(){
        String[] data = "1,2".split(",");
        assertThat(data).contains("1");
    }

    @Test
    void splitOneAndTwoWithOrder(){
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1","2");
    }

    @Test
    void splitOnlyOne(){
        String[] data = "1".split(",");
        assertThat(data).contains("1");
    }
}
