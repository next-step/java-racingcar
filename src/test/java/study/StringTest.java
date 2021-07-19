package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - 1,2을 ','로 split 값 확인 ")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항1 - 1을 ','로 split 값 확인 ")
    void split_requireStep1_1(){
        String[] result = "1".split(",");
        assertThat(result).contains("1");
        assertThat(result[0]).isEqualTo("1");
    }

    @Test
    @DisplayName("요구사항2 -'(1,2)' -> ()을 제고하고 '1,2'를 반환 ")
    void string_requireStep2(){
        String result = "(1,2)".substring(1, 4);

        assertThat(result).isEqualTo("1,2");
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오기")
    void string_requireStep3(){
        String result = "abc";
        int index = 2;
        assertThatThrownBy(() -> {result.charAt(index);}).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index: 4, Size: 4");
    }

}
