package calculator;

import calculator.number.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumbersTest {

    @Test
    @DisplayName("numbers에 있는 모든 숫자를 더한 값을 반환한다.")
    void addAll() {
        // given
        final var texts = new String[]{"1", "5", "4"};
        final var numbers = new Numbers(texts);

        // when
        final var sum = numbers.addAll();

        // then
        assertThat(sum).isEqualTo(10);
    }

}
