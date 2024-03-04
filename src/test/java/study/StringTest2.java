package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest2 {
    @Test
    void splitOneAndTwoWithParentheses(){
        String data = "(1,2)";
        String subData = data.substring(1,4);

        assertThat(subData).isEqualTo("1,2");

    }

}
