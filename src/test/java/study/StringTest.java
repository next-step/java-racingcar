package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @Test
    void split_req1() {
        /*
         * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
         * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
         */

        // given
        String givenString1 = "1,2";
        String givenString2 = "1";

        // when
        String[] splitStringArray1 = givenString1.split(",");
        String[] splitStringArray2 = givenString2.split(",");

        // then
        assertThat(splitStringArray1).containsExactly("1", "2");
        assertThat(splitStringArray2).containsExactly("1");
    }

    @Test
    void  split_req2() {
        /*
         * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
         */

        // given
        String givenString = "(1,2)";

        // when
        String result = givenString.substring(1, givenString.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("String.charAt() 은 특정 위치의 문자를 가져오고, 위치 값 범위를 벗어나면 StringIndexOutOfBoundsException을 발생시킨다.")
    void  split_req3() {
        /*
         * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
         * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
         * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
         */

        // given
        String givenString = "abc";
        int testIndex = givenString.length();

        // when
        char result = givenString.charAt(2);

        // then
        assertThat(result).isEqualTo('c');
        assertThatThrownBy(() -> givenString.charAt(testIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
//                .hasMessage()

    }
}