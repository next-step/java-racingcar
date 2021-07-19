package learningstring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

    @DisplayName("[요구사항1] \"1,2\" 를 \",\" 로 split")
    @Test
    public void splitByComma1() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        // 힌트에 기반한 검증
        assertThat(result.length).isEqualTo(2);
        assertThat(input).contains(result[0]);
        assertThat(input).contains(result[1]);

        // 평소 코딩에 사용하는 검증
        assertThat(input.contains(result[0])).isTrue();
        assertThat(input.contains(result[1])).isTrue();
    }

    @DisplayName("[요구사항1] \"1\" 을 \",\" 로 split")
    @Test
    public void splitByComma2() {
        // given
        String input = "1";

        // when
        List<String> result = Arrays.stream(input.split(","))
            .collect(Collectors.toList());

        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result).containsExactly(input);
    }

    @DisplayName("[요구사항2] \"(1,2)\" 에서 \"()\" 제거")
    @Test
    public void removeBracket() {
        // given
        String input = "(1,2)";
        String expected = input.replaceAll("[()]", "");

        // when
        String result = StringUtil.removeBracket(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("[요구사항3] \"abc\" 로 String.charAt() 테스트")
    @Test
    public void charAt() {
        // given
        String input = "abc";

        // when
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // then
            assertThat(input.indexOf(c)).isEqualTo(i);
        }
    }

    @DisplayName("[요구사항3] 최대 index 를 벗어나는 String.charAt() 호출")
    @Test
    public void charAt_IndexOutOfBounds() {
        // given
        String input = "abc";

        // when
        assertThrows(IndexOutOfBoundsException.class, () -> input.charAt(input.length() + 1));
    }
}
