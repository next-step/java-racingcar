package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void split_test_01(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }
    @Test
    void split_test_02(){
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    void substring_test(){
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 활용해 특정 위치의 문자를 가져오는 테스트")
    void charAt_test(){
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() -> data.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .withFailMessage("Index: \\d+, Size: \\d+");
    }

}
