package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {

    @Test
    @DisplayName(" \"1,2\" 를 , 로 split() 해주었을 때, 1과 2로 잘 분리된다. ")
    void splitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("2","1"); // 순서를 보장하지 않고 포함되어있는 것만 확인한다.
        assertThat(result).containsExactly("1", "2"); // 순서를 보장한다.
    }

    @Test
    @DisplayName("1 만을 , 로 스플릿했을 때, 1만 포함하는 배열이 반환된다.")
    void splitTest2() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }


    @Test
    @DisplayName("substring() 을 이용해 `()` 를 제거한다.")
    void substringTest(){
        String substringValue = "(1,2)".substring(1, 4);
        assertThat(substringValue).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String 의 범위를 벗어난 문자를 가져온다.")
    void charAtTestWithOutOfIndex(){
        assertThatThrownBy(()->{
                "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3")
        ;
    }
}
