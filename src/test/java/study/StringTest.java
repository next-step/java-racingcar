package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("String split 테스트")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");


    }

    @Test
    @DisplayName("charAt 테스트")
    void charAt() {
        String abc = "abc";
        assertThat(abc.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt - IndexOutOfBoundsException 테스트")
    void IndexOutOfBoundsException() {
        String abc = "abc";

        assertThatThrownBy(() -> {
            abc.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);


        assertThatThrownBy(() -> {
            abc.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
