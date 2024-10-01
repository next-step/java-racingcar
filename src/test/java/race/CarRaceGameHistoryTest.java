package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceGameHistoryTest {
    @Test
    void record_게임_진행상황을_기록한다() {
        int round = 2;
        Car[] cars = Car.create(5);

        CarRaceGameHistory[] histories = CarRaceGameHistory.record(round, cars);
        assertThat(histories).hasSize(cars.length);

        for (CarRaceGameHistory history : histories) {
            assertThat(history.getRound()).isEqualTo(round);
            assertThat(history.getCar()).isIn((Object[]) cars);
        }
    }
}
