package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpringTest {

    @Test
    void name() {
        //"1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        String data = "1,2";
        String[] result1 = data.split(",");
        assertThat(result1).contains("1");
        assertThat(result1).contains("2");

        String data2 = "1";
        String[] result2 = data2.split(",");
        assertThat(result2).containsExactly("1");
    }
}
