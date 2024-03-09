package racingcar.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {



    @DisplayName("문자열 숫자 분리")
    @Test
    void splitByComma() {
        String[] values1 = "1,2".split(",");
        String[] values2 = "1".split(",");
        assertThat(values1).contains("1", "2");
        assertThat(values2).containsExactly("1");
    }

    @DisplayName("괄호 내 숫자 분리")
    void splitByCommaInBracket(){
        String values1 = "(1,2)";
        String substring = values1.substring(1, values1.length() - 1);
        assertThat(substring).contains("1", "2");
    }

    @DisplayName("문자열 볌위 검증")
    void getStringInRange(){
        String word = "abc";
        assertThatThrownBy(() -> {
            word.charAt(word.length());
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
