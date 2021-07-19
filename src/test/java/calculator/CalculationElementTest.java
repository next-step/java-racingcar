package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class CalculationElementTest {
    @Test
    void 정적_팩토리_테스트() {
        // given
        Class<CalculationElement> expected = CalculationElement.class;

        // when
        CalculationElement<String> actual = CalculationElement.from(new LinkedList<>());

        //then
        Assertions.assertThat(actual).isInstanceOf(expected);
    }

    @Test
    void 큐_엘리먼트_추가_테스트() {
        // given
        CalculationElement<String> calculationElement = CalculationElement
                .from(new LinkedList<>(List.of()));

        // when
        boolean actual = calculationElement.add("1");

        // then
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void 큐_사이즈_테스트() {
        // given
        int expected = 1;
        CalculationElement<String> calculationElement = CalculationElement
                .from(new LinkedList<>(List.of("1")));

        // when
        int actual = calculationElement.size();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 큐_사이즈_예외_테스트() throws Exception {
        // given
        String expectedMessage = "queue is empty.";
        CalculationElement<String> calculationElement = CalculationElement
                .from(new LinkedList<>());

        // when, then
        Assertions.assertThatThrownBy(() -> calculationElement.poll())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining(expectedMessage);
    }
}
