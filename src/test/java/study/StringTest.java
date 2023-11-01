package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1 - \"1,2\"을 ,로 split 했을 때 1과 2로 분리되는지 테스트")
    void splitTest1(){
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항1 - \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 테스트")
    void splitTest2(){
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("요구사항2 - \"(1,2)\"을 substring()으로 ()을 제거하고 \"1,2\"를 반환하는지 테스트")
    void subStringTest(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).contains("1,2");
    }

    @Test
    @DisplayName("요구사항3 - \"charAt()\"으로 문자열의 특정 위치 문자 가져올 때 StringIndexOutOfBoundsException 발생 테스트")
    void charAtTest(){
        String input = "a,b,c";

        assertThatThrownBy(() -> {
            input.charAt(input.length());
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining(String.valueOf(input.length()));
    }
}
