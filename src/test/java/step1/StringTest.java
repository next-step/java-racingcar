package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @DisplayName("[요구사항1-1] 문자열 \"1,2\"을 \",\" 로 split")
    @Test
    void splitTest1(){
        String[] result  = "1,2".split(",");

        assertThat(result).contains("1","2");
//        assertThat(result).containsExactly("2","1"); // 실패
        assertThat(result).containsExactly("1","2");
    }

    @DisplayName("[요구사항1-2] 문자열 \"1\"을 \",\" 로 split")
    @Test
    void splitTest2(){
        String[] result = "1".split(",");

        assertThat(result.length).isEqualTo(1);
//        Assertions.assertThat(result).contains("2"); // 실패
        assertThat(result).contains("1");
    }

    @DisplayName("[요구사항2] 문자열 (1,2)에서 '(', ')' 제거 ")
    @Test
    void substringTest(){
        String words = "(1,2)";

        String result = words.substring(1,words.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("[요구사항3] 문자열 최대 인덱스 넘어가는 값 호출 (에러발생).")
    @Test
    void charAt_IndexOutOfBounds(){
        String word = "abc";
        assertThatThrownBy(()->{
            word.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("index out of range");

    }

}
