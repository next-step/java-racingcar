package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SubStringTest {


    @Test
    public void 괄호제거_테스트(){
        String target = "(1,2)";
        String result = target.substring(1, target.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }
}
