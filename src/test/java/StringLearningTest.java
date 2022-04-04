import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringLearningTest {

    @DisplayName("string을 , 기준으로 split했을 때 성공적으로 나눠진다.")
    @Test
    void split_StringNumberGiven_SuccessSplit() {
        // given
        String number = "1,2";

        // when
        String[] splittedNumber = number.split(",");

        // then
        assertThat(splittedNumber).contains("1", "2");
    }

    @DisplayName("하나의 문자인 String을 split했을 때도 배열이 반환된다.")
    @Test
    void split_StringGiven_ShouldReturnArray() {
        // given, when
        String[] split = "1".split(",");

        // then
        assertThat(split).containsExactly("1");
    }
}
