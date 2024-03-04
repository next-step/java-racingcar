package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split(){
        String[] result = "1,2".split(",");
        //System.out.println(result[0]);
        //assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }
}
