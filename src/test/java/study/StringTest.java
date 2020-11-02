package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    //@Test 메서드가 호출할 때 마다 새로운 인스턴스를 생성하여 독립적인 테스트가 이루어지게 한다.
    @Test
    @DisplayName("split 테스트 ")
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");//순서와 상관 없이 실제 그룹이 주어진 값들을 포함하고 있는지를 테스트
        assertThat(result).containsExactly("1,2"); //순서까지 고려해서 실제 그룹이 주어진 값들을 포함하고 있는지를 테스트 정확하게 일치해야함
    }
    @Test
    @DisplayName("substring 테스트")
    void substring(){
        String str = "(1,3)";
        String result = str.substring(1,str.length()-1);
        assertThat(result).isEqualTo("1,2");//값이 같은지 검증하기(주소값 아님)
    }
    @Test
    @DisplayName("charAt 테스트")
    void charAt(){
        char ch = "abc".charAt(1);
        assertThat(ch).isEqualTo('b');

    }
    @Test
    @DisplayName("Exception 테스트")
    void exception1(){
    assertThatThrownBy(() -> {
          String str = null;
          char ch = str.charAt(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("Index: 2, Size: 2");


    }






}
