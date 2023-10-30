package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@DisplayName("String 클래스 학습 테스트")
public class StringTest {

    private static final String COMMA = ",";

    @Test
    @DisplayName("1,2를 ,로 분리했을 때 1과 2로 분리된다")
    public void quest1_1() {
        String target = "1,2";
        String[] splited = target.split(COMMA);

        assertThat(splited).contains("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 분리했을 때 1만 포함하는 배열이 반환된다")
    public void quest1_2() {
        String target = "1";
        String[] splited = target.split(COMMA);

        assertThat(splited).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2)에서 substring으로 괄호를 제거한다")
    public void quest2() {
        String target = "(1,2)";
        String exceptBracket = target.substring(1, target.length() - 1);

        assertThat(exceptBracket).isEqualTo("1,2");
    }

    @Test
    @DisplayName("벗어난 인덱스 접근 시 예외가 발생한다")
    public void quest3() {
        String target = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                target.charAt(3);
            }).withMessageMatching("String index out of range: \\d+");
    }

}
