package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    public void split(){
        //given
        //when
        String[] results = "1,2".split(",");
        //then
        assertThat(results).containsExactly("1", "2");
    }
}
