package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {

    @Test
    void testTheSameCarNames() {
        Name carTomoFirst = new Name("tomo");
        Name carTomoSecond = new Name("tomo");

        assertThat(carTomoFirst.equals(carTomoSecond)).isTrue();
    }

    @Test
    void testDifferentCarNames() {
        Name carTomo = new Name("tomo");
        Name carPobi = new Name("pobi");

        assertThat(carTomo.equals(carPobi)).isFalse();
    }

    @Test
    void testNameLengthGreaterThanFive() {
        assertThatThrownBy(() -> new Name("tomotomo")).isInstanceOf(IllegalArgumentException.class);
    }
}
