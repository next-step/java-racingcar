package step3.racinggame.core;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GasStationTest {

    @Test
    @DisplayName("0~9까지의 랜덤한 양의 기름을 파는 테스트")
    void get_random_fuel() {
        GasStation gasStation = new GasStation();

        int fuel = gasStation.sellFuel();

        assertThat(fuel).isBetween(0, 9);
    }

}
