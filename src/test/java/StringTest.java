import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
        //given
        String numberString = "(1,2)";

        //when
        String[] result = numberString.substring(1, numberString.length() - 1).split(",");

        //then
        assertThat(result).containsExactly("1","2");
    }


    @Test
    @DisplayName("charAt() 특정위치의 문자 확인")
    void charAt(){
        //given
        String value = "abc";
        int index = 2;

        //when
        char actual = value.charAt(index);

        //then
        assertThat(actual).isEqualTo('c');
    }

    @ParameterizedTest
    @CsvSource({"abc,3", "abcd,4"})
    @DisplayName("charAt() IndexOutOfBoundsException")
    void charAt_IndexOutOfBoundsException(String value,int index){
        assertThatThrownBy(() -> {
            value.charAt(index);//when
        }).isInstanceOf(IndexOutOfBoundsException.class);//then
    }
}
