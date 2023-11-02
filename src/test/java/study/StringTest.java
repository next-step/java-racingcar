package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @Test
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).contains("1","2");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    String subString() {
        String result = "1,2".substring(0);
        result = result.substring(-1);

        assertThat(result).isEqualTo("1,2");

        return result;
    }

    @Test
    @DisplayName("요구사항3-1: charAt() 메소드를 활용해 특정 위치의 문자 가져오는 테스트")
    void charAt(){
        String str = "abc";
        char result = str.charAt(1);

        assertThat(result).isEqualTo('b');
    }


    @Test
    @DisplayName("요구사항3-2: 위치 값을 벗어나면 StringIndexOutOfBoundsException발생 테스트")
    void charAtException(){
        String str = "abc";
        int index = 5;

        assertAll(
                () -> assertThatThrownBy(() -> {
                        char result = str.charAt(index);
                    }).isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining("String index out of range: "+index)
                ,
                () -> assertThatExceptionOfType(IndexOutOfBoundsException.class)
                        .isThrownBy(() -> {
                            char result = str.charAt(index);
                        }).withMessageMatching("String index out of range: "+index)
        );


    }


}
