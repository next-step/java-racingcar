package racinggame.domain.gasstation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.exception.EmptyTankException;

class TankGasStationTest {

    @Test
    @DisplayName("연료탱크의 앞부분부터 차례로 기름을 판다.")
    void sell_fuel_from_tank() {
        Queue<Integer> tank = new LinkedList<>(List.of(1, 2, 3, 4, 5));

        TankGasStation gasStation = new TankGasStation(tank);

        for (int i = 1; i <= 5; i++) {
            assertThat(gasStation.sellFuel()).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("연료탱크에 연료가 없을 때 팔면 예외 발생.")
    void fail_to_sell_fuel_from_empty_tank() {
        Queue<Integer> tank = new LinkedList<>();

        TankGasStation gasStation = new TankGasStation(tank);

        assertThatThrownBy(gasStation::sellFuel)
                .isInstanceOf(EmptyTankException.class);
    }
}