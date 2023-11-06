package study;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void carRace() {
        assertThat(CarRace.race(RaceEntry.of(1, 1))).hasDimensions(1, 1);
        assertThat(CarRace.race(RaceEntry.of(5, 5))).hasDimensions(5, 5);
    }
}
