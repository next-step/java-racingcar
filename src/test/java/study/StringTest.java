package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("[요구사항 1] 구분자가 문자열에 있는 경우, split() 테스트")
    void 구분자_있는_split_함수_테스트() {
        //given
        String line = "1,2";

        //when
        String[] result = line.split(",");

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("[요구사항 1] 구분자가 문자열에 없는 경우, split() 테스트")
    void 구분자_없는_split_함수_테스트() {
        //given
        String line = "1";

        //when
        String[] result = line.split(",");

        //then
        assertThat(result).contains("1");
    }

    @Test
    @DisplayName("[요구사항 2] substring() 테스트")
    void substring_함수_테스트() {
        //given
        String line = "(1,2)";

        //when
        String result = line.substring(1, 4);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("[요구사항 3] charAt() 정상 테스트")
    void charAt_함수_정상_테스트() {
        //given
        String line = "abc";

        //when
        Character resultOfNormal = line.charAt(1);

        //then
        assertThat(resultOfNormal).isEqualTo('b');
    }

    @Test
    @DisplayName("[요구사항 3] charAt() 예외 테스트")
    void charAt_함수_예외_테스트() {
        //given
        String line = "abc";

        //when

        //then
        assertThatThrownBy(() -> line.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }
}
