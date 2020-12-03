package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    @DisplayName("String 클래스의 split 테스트")
    void split() {
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1", "2");
        
        data = "1".split(",");
        assertThat(data).contains("1");
    }

}
