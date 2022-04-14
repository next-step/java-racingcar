package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RuleTest {

    @Test
    void carNamesGiven_ReturnCars() {
        String[] carNames = {"car", "car2"};
        assertThat(new Rule(carNames, 3).readyCars().size()).isEqualTo(carNames.length);
    }
}
