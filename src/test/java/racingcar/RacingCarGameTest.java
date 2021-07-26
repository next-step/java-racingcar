package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCar;
import racingcar.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    private final List<RacingCar> randomMoveRacingCars = new ArrayList<>();
    public static final int carNumber = 3;
    public static final int tryNumber = 5;

    @BeforeEach
    void setUp() {
        RacingCarGame.initializeRacingCars(randomMoveRacingCars, carNumber, new RandomMoveStrategy());
    }

    @Test
    @DisplayName("레이싱 카의 차량대수로 초괴화를 했을 때 리스트의 사이즈가 변하는 것을 확인한다.")
    void initializeRacingCars() {
        assertThat(randomMoveRacingCars.size()).isEqualTo(carNumber);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤무브 레이싱카 게임의 race()를 완료했을 때 racingCar position 은 0 이상 tryNumber 이하 임을 확인한다.")
    void race() {
        RacingCarGame.race(randomMoveRacingCars, tryNumber);
        for (RacingCar racingCar: randomMoveRacingCars) {
            assertThat(racingCar.getPosition()).isLessThanOrEqualTo(tryNumber);
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        }
    }

    @RepeatedTest(10)
    @DisplayName("한 번 경주한 랜덤 무브 차들의 위치는 0 또는 1임을 확인한다.")
    void raceOneStep() {
        RacingCarGame.raceOneStep(randomMoveRacingCars);
        for (RacingCar racingCar: randomMoveRacingCars) {
            assertThat(racingCar.getPosition()).isLessThanOrEqualTo(RacingCar.ONE_STEP);
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        }
    }
}