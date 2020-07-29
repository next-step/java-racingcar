package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    public void split() {
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1", "2"); //순서까지 체크
    }

    @Test
    public void extract() {
        String data = "(1,2)".substring(1,4);
        assertThat(data).contains("1,2"); //순서 미체크
    }

    @Test
    public void findCharAt() {
        // throw를 기대하는 메소드(throw가 없다면 fail)
        assertThatThrownBy(() -> {
            "abc".charAt(2);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
