package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("split 메소드는 구분자(,) 기준으로 문자 배열을 리턴한다")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName("subString 메서드는 문자열 인덱스 범위를 기준으로 문자열을 잘라서 리턴한다")
    void subString(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("chatAt은 지정한 인덱스에 위치한 문자 한 개를 리턴한다")
    void charAt(){
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt은 인덱스 벗어난 문자를 조회 시 예외가 발생한다")
    void validateCharAt(){
        assertThatThrownBy(() -> "abc".charAt("abc".length() + 100))
            .isInstanceOf(StringIndexOutOfBoundsException.class);
    }


}
