package StringSplit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringSplitTest {
    @Test
    void split_string_1_and_2() {
        //given
        String testString = "1,2";
        //when
        String[] splitResult = testString.split(",");
        //then
        assertThat(splitResult).contains("1");
        assertThat(splitResult).contains("2");
        assertThat(splitResult).containsExactly("1","2");

    }

    @Test
    void split_string_1_return_array_contain_1(){
        //given
        String testString = "1";
        //when
        String[] splitResult = testString.split(",");

        //then
        assertThat(splitResult).contains("1");
        assertThat(splitResult).containsExactly("1");
    }

    @Test
    void  substring_method_test(){
        //given
        String testString = "(1,2)";
        //when
        String subStringResult = testString.substring(1,4);
        //then
        assertThat(subStringResult).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 이용해 1번째 char를 반환 받는다.")
    void  string_charAt_method_test(){
        //given
        String testString = "abc";
        //when
        char charResult = testString.charAt(1);
        //then
        assertThat(charResult).isEqualTo('b');
    }

    @Test
    @DisplayName("범위보다 큰 숫자를 지정했을 때 StringIndexOutOfBoundsException 발생한다.")
    void string_charAt_method_throw_StringIndexOutOfBoundsException(){
        //given
        String testString = "abc";
        //when
        //then
        assertThrows(StringIndexOutOfBoundsException.class, ()
        -> testString.charAt(3));

        assertThatThrownBy(()
                -> testString.charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
