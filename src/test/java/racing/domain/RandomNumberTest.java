package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RandomNumberTest {
    @RepeatedTest(10)
    @DisplayName("-2로 생성시 익셉션")
    void random_num_exception() {
        assertThatThrownBy(() -> new RandomNumber(-2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0과 9사이의 값이 아닙니다.");
    }
}