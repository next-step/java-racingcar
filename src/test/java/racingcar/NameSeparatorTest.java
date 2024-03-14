package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.NameSeparator;

import static org.assertj.core.api.Assertions.assertThat;

public class NameSeparatorTest {

    @Test
    @DisplayName("[성공] 쉼표로 구분된 이름 문자열을 분리한다.")
    void 쉼표_문자열_구분() {
        // When
        String[] actual = NameSeparator.separate("pobi,crong,honux");

        // Then
        assertThat(actual).containsExactlyInAnyOrder("pobi", "crong", "honux");
    }

    @Nested
    @DisplayName("[학습 테스트] String.split()")
    class StringSplitLearningTest {

        @Test
        @DisplayName("빈 문자열이 들어왔는데 쉼표로 split 하는 경우")
        void 빈_문자열_split() {
            assertThat("".split(",")).hasSize(1); // not throw npe
        }
    }
}
