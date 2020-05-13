package study.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("요구사항1 : 1,2 을 , 로 split 했을 때 1과 2로 잘 분리되는지 테스트 ")
    void split1(){
        String [] result = "1,2".split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("요구사항1 : 1을 , 로 split 했을 때 1만 포함되는 배열이 반환되는지 테스트")
    void split2(){
        String [] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2 : (1,2) 값이 주어졌을 때 subString 메소드 활용하여 괄호() 제거하고 1,2 반환되는지 테스트 ")
    void subString(){
        String target = "(1,2)";
        String result = target.substring(1, target.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 : charAt 메소드 활용하여 특정 위치 문자 가져오기 테스트")
    void charAt1(){
        String target = "abc";
        char result = target.charAt(1);
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("요구사항3 : charAt 메소드 활용하여  StringIndexOutOfBoundsException 발생 테스트")
    void charAt2(){
        String target = "abc";
        int index = target.length(); // 인덱스 위치 값 초과
        assertThatThrownBy(()->{
            target.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: "+index);
    }
}
