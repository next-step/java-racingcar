package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    // 요구사항 1-1
    @Test
    void splitTestFst(){
        String [] result = "1,2".split(",");
        assertThat(result).containsExactly("1","2");
    }

    // 요구사항 1-2
    @Test
    void splitTestSec(){
        String [] result = "1".split(",");
        assertThat(result).containsOnly("1");
    }

    // 요구사항 2
    @Test
    void substrTest(){
        String trgStr = "(1,2)";
        String result = trgStr.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    // 요구사항 3
    @Test
    @DisplayName("String charAt() String 인덱스 범위값 확인 학습")
    void charAtTest(){

        String trgStr = "abc";

        assertThatThrownBy(() -> trgStr.charAt(trgStr.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.valueOf(trgStr.length()));
    }
}
