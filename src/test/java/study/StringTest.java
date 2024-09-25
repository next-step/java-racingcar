package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

    @DisplayName("split() 사용")
    @Test
    void split(){
        String given = "1,2";

        String[] result = given.split(",");

        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }


    @DisplayName("substring() 사용")
    @Test
    void substring(){
        String given = "(1,2)";

        String result = given.substring(1, given.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("정상적인 특정 위치에서 문자 가져오기")
    @Test
    void charAt(){
        String given = "abc";

        char resultA = given.charAt(0);
        char resultB = given.charAt(1);
        char resultC = given.charAt(2);

        assertThat(resultB).isEqualTo('b');
        assertThat(resultA).isEqualTo('a');
        assertThat(resultC).isEqualTo('c');
    }

    @DisplayName("범위 밖의 위치에서 문자 가져오기")
    @Test
    void charAt_예외_발생(){
        String given = "abc";

        assertThatThrownBy(()->given.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
