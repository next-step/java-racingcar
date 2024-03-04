package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void split(){
        String[] result = "1,2".split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    public void substring(){
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }
}
