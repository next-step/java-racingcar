package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleTest {

    @Test
    void countOfCarGiven_ReturnCars() {
        int countOfCar = 3;
        assertThat(new Rule(countOfCar, 3).readyCars().size()).isEqualTo(countOfCar);
    }
}
