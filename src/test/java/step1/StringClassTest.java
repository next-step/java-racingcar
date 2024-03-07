package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class StringClassTest {

//  요구사항 1
    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void splitTest(){
        String value = "1,2";
        String[] actual = value.split(",");

        String expectedComponent1 = "1";
        assertThat(actual).contains(expectedComponent1);

        String expectedComponent2 = "2";
        assertThat(actual).contains(expectedComponent2);
    }

    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splitAndReturnArrayTest(){
        String value = "1";
        String[] actual = value.split(",");
        String[] expected = {"1"};
        assertThat(actual).containsExactly(expected);
    }

//  요구사항 2
    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환하도록 구현.")
    void substringTest(){
        String value = "(1,2)";
        String actual = value.substring(1, value.length() - 1);
        String expected = "1,2";
        assertThat(actual).isEqualTo(expected);
    }

//  요구사항 3
    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현.")
    void charAtTest(){
        String value = "abc";

        char expectedChar1 = 'a';
        char actualChar1 = value.charAt(0);
        assertThat(actualChar1).isEqualTo(expectedChar1);

        char expectedChar2 = 'b';
        char actualChar2 = value.charAt(1);
        assertThat(actualChar2).isEqualTo(expectedChar2);

        char expectedChar3 = 'c';
        char actualChar3 = value.charAt(2);
        assertThat(actualChar3).isEqualTo(expectedChar3);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현.")
    void charAtWithStringIndexOutOfBoundsExceptionTest(){
        String value = "abc";
        int index = 4;
        assertThatThrownBy(() -> {
            value.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
