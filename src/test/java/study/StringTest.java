package study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest {

    //요구사항1
    @Test
    void split1(){

        String Test1 = "1,2";
        String[] Test1Result1 = Test1.split(",");
        assertThat(Test1Result1).contains("1");
        assertThat(Test1Result1).containsExactly("1","2");

        String[] Test2 = "1,".split(",");
        assertThat(Test2).contains("1");
    }

    //요구사항2
    @Test
    void split2(){
        String Test2 = "(1,2)".substring(1,4);
        assertThat(Test2).contains("1,2");
    }

    //요구사항3
    @Test
    @DisplayName("abc의 길이를 벗어나면 StringIndexOutOfBoundsException와 일치하여 예외처리")
    void split3(){

        assertThatThrownBy(() -> {
            String Test3 = "abc";
            Test3.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

    }

}
