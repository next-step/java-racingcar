import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {

    @Test
    @DisplayName("'1,2'를 ','로 split 했을 때, 1과 2로 잘 분리된다.")
    void split_쉼표분리() {
        // given
        String value = "1,2";

        // when
        String[] split = value.split(",");

        // then
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("'1'을 ','로 split 했을 때 ,1만을 포함하는 배열이 반환된다.")
    void split_단일_문자_쉼표분리() {
        // given
        String value = "1";

        // when
        String[] split = value.split(",");

        // then
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때, String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환한다.")
    void substring_괄호제거() {
        // given
        String value = "(1,2)";

        // when
        String substring = value.substring(1, 4);

        // then
        assertThat(substring).isEqualTo("1,2");
    }

    @ParameterizedTest(name ="'abc' 값이 주어졌을 때, String의 charAt({0}) 메소드를 활용해 해당 위치의 문자를 가져올 수 있다.")
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    void charAt_특정위치_문자추출(int idx, char expectedCh) {
        // given
        String value = "abc";

        // when
        char ch = value.charAt(idx);

        // then
        assertThat(ch).isEqualTo(expectedCh);
    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때," +
            " 위치 값을 벗어나면 StringIndexOutOfBoundsException 예외가 발생한다.")
    void charAt_문자_크기를_벗어나는_문자추출() {
        // given
        String value = "abc";
        int invalidIndex = value.length() + 1;

        // when then
        assertThatThrownBy(() -> value.charAt(invalidIndex))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
