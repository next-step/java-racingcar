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
}
