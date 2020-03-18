package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1"); // assertThat이라는 라이브러리를 이용해서, data에 내가 원하는 값이 있는지 확인한다.
        assertThat(result).containsExactly("1", "2"); //containsExactly : 해당 순서로 값이 잘 들어있는지까지 확인
    }
}