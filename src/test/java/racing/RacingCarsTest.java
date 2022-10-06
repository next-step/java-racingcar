package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("플레이어수만큼 자동차를 만든다.")
    void test_create_racing_cars() {
        final int playerCount = 3;
        assertThat(RacingCars.createRacingCars(playerCount).getRacingCars().size()).isEqualTo(playerCount);
    }

}