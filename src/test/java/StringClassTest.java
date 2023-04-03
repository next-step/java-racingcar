import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringClassTest {

    @Test
    @DisplayName(" \"1,2\" 문자열은 ',' 구분자로 분리되어야 한다.")
    void split_01() {
        //given
        String word = "1,2";

        //when
        String[] result = word.split(",");

        //then
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName(" \"1는 ','로 분리 했을 시, \"1\"만 반환해야 한다.")
    void split_02() {
        //given
        String word = "1";

        //when
        String[] result = word.split(",");

        //then
        assertThat(result).containsExactly("1");
        assertEquals(1, result.length);
    }

    @Test
    @DisplayName("substring()을 통한 () 제거")
    void substring() {
        //given
        String word = "(1,2)";

        //when
        String result = word.substring(1, word.length() - 1);

        //then
        assertEquals("1,2", result);
    }
}
