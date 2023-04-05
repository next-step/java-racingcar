package learning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"를 , 로 split 하면 1과 2로 나뉘어진다.")
    void testStringWithOneCommaTwo() {
        //arrange
        String target = "1,2";

        //act
        String[] split = target.split(",");

        //assert
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 하면 1만 포함하는 배열을 반환한다.")
    void testStringWithOneComma() {
        //arrange
        String target = "1,";

        //act
        String[] split = target.split(",");

        //assert
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때, String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환한다.")
    void testStringWithOneCommaTwoAndBracket() {
        //arrange
        String target = "(1,2)";

        //act
        String substring = target.substring(1, target.length() - 1);

        //assert
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
    void testStringWithCharAt() {
        //arrange
        String target = "abc";

        //act
        char charAt0 = target.charAt(0);
        char charAt1 = target.charAt(1);
        char charAt2 = target.charAt(2);

        //assert
        assertThat(charAt0).isEqualTo('a');
        assertThat(charAt1).isEqualTo('b');
        assertThat(charAt2).isEqualTo('c');
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용할 때 값이 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void testStringWithCharAtOutOfIndex() {
        //arrange
        String target = "abc";

        //assert
        assertThatThrownBy(() -> {
            //act
            target.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
