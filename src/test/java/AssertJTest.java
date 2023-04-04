import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 1, 2, 3);
    }

    @DisplayName("Assertj의 메서드는 체이닝 해서 검증 하는 것이 가능하다.")
    @Test
    void chaining_assertj_method() {
        assertThat(numbers)
            .isNotEmpty()
            .contains(1)
            .containsSequence(2, 3)
            .containsExactly(1, 1, 2, 3)
            .doesNotContain(4, 5, 6)
            .doesNotContainNull();
    }
}
