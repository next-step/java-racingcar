package racing_winner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private RacingCar racingCar;
    private static final int BASE_NUMBER = 0;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("pobi");
    }

    @Test
    @DisplayName("더 멀리 움직인 자동차 거리 확인")
    void findFartherDistance() {
        racingCar.move();
        int distance = racingCar.findFartherDistance(BASE_NUMBER);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    @DisplayName("가장 멀리 움직인 자동차 이름 확인")
    void findMovedMaxDistance() {
        String winner = racingCar.findMovedMaxDistanceCar(BASE_NUMBER);
        assertThat(winner).isEqualTo("pobi");
    }


}