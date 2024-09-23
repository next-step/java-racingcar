package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {


    @Test
    public void 숫자_두개_분리_테스트(){
        String[] split = "1,2".split(",");
        assertThat(split.length).isEqualTo(2);
        assertThat(split).contains("1","2");
    }

    @Test
    public void 숫자_한개_분리_테스트(){
        String[] split = "1".split(",");
        assertThat(split.length).isEqualTo(1);
        assertThat(split).contains("1");
    }
}
