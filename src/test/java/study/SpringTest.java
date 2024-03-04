package study;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpringTest {

    @Test
    void split(){
        String [] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");

    }
}
