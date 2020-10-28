package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split() 테스트")
    void splitTest(){

        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");

    }

    @Test
    @DisplayName("substring() 테스트")
    void substringTest(){

        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");

    }

    @Test
    @DisplayName("charAt() 테스트")
    void charAtTest(){
        assertThat("abc".charAt(0)).isEqualTo('a');
        assertThat("abc".charAt(1)).isEqualTo('b');
        assertThat("abc".charAt(2)).isEqualTo('c');



    }

    @Test
    @DisplayName("charAt() 테스트. 예외 시 IOOB Exception 발생")
    void charAtTest_ShouldThrowIndexOutOfBoundsExceptionTest(){

        assertThatThrownBy( () -> {
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
          .hasMessageContaining("out of range");

    }
}
