package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String data = "1,2";
        String[] result =  data.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring() {
        String data = "(1,2)";
        String result = data.substring(1, data.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드 테스트 코드를 요구사항에 맞게 구현해본다.")
    @Test
    void charat() {
        String data = "abc";
        String result = data.charAt(0)+"";

        assertThat(result).isEqualTo("a");

        assertThatThrownBy(() -> {
            data.charAt(4);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Out Of Range!!!");

    }



}

