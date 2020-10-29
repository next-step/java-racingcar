package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    //String 클래스에 대한 학습 테스트
    @Test
    @DisplayName("요구사항1 : split 활용")
    void splitTest(){
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1","2");
    }

    @Test
    @DisplayName("요구사항2 : String의 substring() 메소드 활용")
    void subStringTest(){
        String data = "(1,2)".substring(1,4);
        assertThat(data).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3 :String의 charAt() 메소드 활용")
    void charAtTest(){
        String data = "abc";
        assertThat(data.charAt(0)).isEqualTo('a');
        assertThat(data.charAt(1)).isEqualTo('b');
        assertThat(data.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(()->{
                    data.charAt(3);
                }).withMessageMatching("String index out of range: 3");

    }

}
