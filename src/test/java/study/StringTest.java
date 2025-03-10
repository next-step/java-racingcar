package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void stringSplitTest1(){  // 요구사항 1
        //given
        String given = "1,2";

        //when
        String[] result = given.split(",");

        //then
        assertThat(result).containsExactly("1", "2");
    }
    @Test
    void stringSplitTest2(){  // 요구사항 1
        //given
        String given = "1,1";

        //when
        String[] result = given.split(",");

        //then
        assertThat(result).containsExactly("1", "1");
    }
    @Test
    void subStringTest(){  // 요구사항 2
        //given
        String given = "(1,2)";

        //when
        String result = given.substring(1, given.length()-1);

        //then
        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("charAt 테스트 (요구사항 3)")
    void charAtTest(){  // 요구사항 3
        //given
        String given = "abc";

        //when, then
        assertThatThrownBy(() -> {
            given.charAt(3);
            // ...
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}
