package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RandomMove;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final int STANDARD_MOVEMENT = 0;
    private static final int BOUND = 1;
    private static final RandomMove RANDOM_MOVE = new RandomMove(STANDARD_MOVEMENT, BOUND);
    private String NAME_ONE = "pobi";
    private String NAME = "pobi,crong";
    private RacingCar racingCar;

    @BeforeEach
    void setup() {
        racingCar = new RacingCar(NAME, RANDOM_MOVE);
    }

    @Test
    @DisplayName("레이싱 차 준비 됐는지")
    void isRacingCar() {
        assertThat(racingCar.carReady(NAME).getCar().get(0).getName()).isEqualTo(NAME_ONE);
    }

    @Test
    @DisplayName("차 움직임 테스트")
    void canCarPlay() {
        racingCar.racingPlay();

        assertThat(racingCar.getCarList().get(0).getPosition()).isEqualTo(1);
    }

}
