import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {

    private static final String DELIMITER = ",";

    @DisplayName("1,2를 ','로 split 했을 때 1과 2를 포함한 배열이 반환된다.")
    @Test
    void split_string_delimiter() {
        //given
        String text = "1,2";

        //when
        String[] result = text.split(DELIMITER);

        //then
        assertAll(
                ()-> assertThat(result).containsOnly("1", "2"),
                ()-> assertThat(result).containsExactly("1", "2")
        );
    }

    @DisplayName("1을 ','로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    @Test
    void split_string_delimiter_not_contain_delimiter() {
        //given
        String text = "1";

        //when
        String[] result = text.split(DELIMITER);

        //then
        assertThat(result).containsOnly("1");
    }

    @DisplayName("(1,2)를 substring() 메서드로 괄호를 제거하면 '1,2'가 반환된다.")
    @Test
    void remove_bracket() {
        //given
        String text = "(1,2)";

        //when
        String result = text.replaceAll("\\s", "").substring(1, text.length() - 1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 문자열에서 charAt() 메서드로 특정 위치의 문자를 가져올 수 있다.")
    @Test
    void get_char_within_range() {
        //given
        String text = "abc";

        //when, then
        assertThat(text.charAt(0)).isEqualTo('a');
    }

    @DisplayName("charAt() 메서드의 인자가 주어진 문자열의 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void get_char_without_range() {
        //given
        String text = "abc";
        int index = text.length();

        //when, then
        assertThatThrownBy(() -> "abc".charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + index);
    }

}