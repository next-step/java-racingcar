package stringtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    
    @Test
    void requirementTest1(){
        String[] strArray = "1,2".split(",");
        assertThat(strArray).contains("1", "2");
        assertThat(strArray).contains("1", strArray[0]);
        assertThat(strArray).containsExactly("1", "2");

        String[] strArray2 = strArray[0].split(",");
        assertThat(strArray2).contains("1", strArray2[0]);
    }

    @Test
    void requirementTest2(){
        String str = "(1,2)";
        String subStr = str.substring(1,4);
        assertEquals("1,2", subStr);
    }

    @Test
    @DisplayName("요구사항 3을 충족한다.")
    void requirementTest3(){
        String str = "a,b,c";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(4)).isEqualTo('c');

    }

    @Test
    @DisplayName("요구사항 3을 충족한다, Exception 처리")
    void requirementTest4(){
        String str = "a,b,c";
        assertThatThrownBy(()->{
            assertThat(str.charAt(5)).isEqualTo('c');
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("Index: 5, Size 4, index out of range");
    }
}