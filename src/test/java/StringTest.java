import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class StringTest {
    @Test
    @DisplayName("String split 문자열 분리 확인")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("substring() 메서드 확인")
    void substring(){
        String numberString = "(1,2)";
        String[] result = numberString.substring(1, numberString.length() - 1).split(",");
        assertThat(result).containsExactly("1","2");
    }


    @Test
    @DisplayName("charAt() 특정위치의 문자 확인")
    void charAt(){
        String value = "abc";
        int index = 2;

        char actual = value.charAt(index);
        assertThat(actual).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt() IndexOutOfBoundsException")
    void charAt_IndexOutOfBoundsException(){
        String value = "abc";
        int index = 3;

        assertThatThrownBy(() -> {
            value.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
