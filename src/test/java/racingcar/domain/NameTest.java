package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Name;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    private final String TOMO = "tomo";
    private final String POBI = "pobi";
    private final String NAME_WHOSE_LENGTH_IS_GREATER_THAN_FIVE = "tomotomo";

    @Test
    void testTheSameCarNames() {
        Name carTomoFirst = new Name(TOMO);
        Name carTomoSecond = new Name(TOMO);

        assertThat(carTomoFirst.equals(carTomoSecond)).isTrue();
    }

    @Test
    void testDifferentCarNames() {
        Name carTomo = new Name(TOMO);
        Name carPobi = new Name(POBI);

        assertThat(carTomo.equals(carPobi)).isFalse();
    }

    @Test
    void testNameLengthGreaterThanFive() {
        assertThatThrownBy(() -> new Name(NAME_WHOSE_LENGTH_IS_GREATER_THAN_FIVE)).isInstanceOf(IllegalArgumentException.class);
    }
}
