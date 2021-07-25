package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    private final List<RacingCar> racingCars = new ArrayList<>();
    public static final int carNumber = 3;
    public static final int tryNumber = 5;

    @BeforeEach
    void setUp() {
        RacingCarGame.initializeRacingCars(racingCars, carNumber);
    }

    @Test
    @DisplayName("레이싱 카의 차량대수로 초괴화를 했을 때 리스트의 사이즈가 변하는 것을 확인한다.")
    void initializeRacingCars() {
        assertThat(racingCars.size()).isEqualTo(carNumber);
    }

    @RepeatedTest(10)
    @DisplayName("한 번 경주한 차들의 위치는 0 또는 1임을 확인한다.")
    void raceOneStep() {
        RacingCarGame.raceOneStep(racingCars);
        for (RacingCar racingCar: racingCars) {
            assertThat(racingCar.getPosition()).isLessThanOrEqualTo(RacingCar.ONE_STEP);
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        }
    }
}