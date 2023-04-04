package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class StringTest {
    @Test
    @DisplayName("구분자")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");

    }
    @Test
    @DisplayName("문자열자르기")
    void substring(){
        String result = "(1,2)";
        int bracket1 = result.indexOf("(");
        int bracket2 = result.indexOf(")");
        result = result.substring(bracket1+1, bracket2);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("찾는 범위를 벗어나는지")
    void chaAt() {
        String result = "abc";
        int len = result.length();
            assertThatThrownBy(() -> {
              for(int i =0; i <= len; i++){
                  result.charAt(i);
                }
            }).isInstanceOf(IndexOutOfBoundsException.class)
                    .hasMessageContaining(String.valueOf(len))
                    .hasMessageEndingWith(String.valueOf(len));

/*
hasNoCause() : thrown 여부 확인
hasMessageEndingWith() : 에러 메시지가 특정 문자로 끝나는지 확인
hasMessageContaining("exception") : 에러 메시지에 특정 문자열이 포함되는지 확인
git 버전확인하기
 */

    }





}
