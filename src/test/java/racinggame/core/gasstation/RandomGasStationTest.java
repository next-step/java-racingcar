package racinggame.core.gasstation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGasStationTest {

    @Test
    @DisplayName("0~9까지의 랜덤한 양의 기름을 파는 테스트")
    void sell_random_fuel() {
        RandomGasStation gasStation = new RandomGasStation();

        int fuel = gasStation.sellFuel();

        assertThat(fuel).isBetween(0, 9);
    }

}
