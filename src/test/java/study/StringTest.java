package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void split(){
        String input = "1,2";

        String[] result = input.split(",");

        assertThat(result).contains("1");
        assertThat(result).contains("2");
        assertThat(result).contains("1","2");

        // containsExactly - 순서까지 일치 확인
//        assertThat(result).containsExactly("2","1");

        assertThat(result).containsExactly("1","2");
    }
}
