package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarNameTest {

    @Test
    void testTheSameCarNames() {
        CarName carTomoFirst = new CarName("tomo");
        CarName carTomoSecond = new CarName("tomo");

        assertThat(carTomoFirst.equals(carTomoSecond)).isTrue();
    }

    @Test
    void testDifferentCarNames() {
        CarName carTomo = new CarName("tomo");
        CarName carPobi = new CarName("pobi");

        assertThat(carTomo.equals(carPobi)).isFalse();
    }
}
