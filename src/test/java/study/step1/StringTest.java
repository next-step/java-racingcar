package study.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void split(){
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1","2");
    }

    @Test
    void substring(){
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chartAt 으로 특정위치의 문자를 가져올 때 StringIndexOutOfBoundsException을 발생시킨다")
    void charAt(){
        assertThatThrownBy(()->{
            "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
