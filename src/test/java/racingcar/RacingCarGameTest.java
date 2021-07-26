package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCar;
import racingcar.strategy.AlwaysMoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {
    private final List<RacingCar> randomMoveRacingCars = new ArrayList<>();
    private final List<RacingCar> alwaysMoveRacingCars = new ArrayList<>();
    public static final int CAR_NUMBER = 5;
    public static final int TRY_NUMBER = 10;

    @BeforeEach
    void setUp() {
        RacingCarGame.initializeRacingCars(randomMoveRacingCars, CAR_NUMBER, new RandomMoveStrategy());
        RacingCarGame.initializeRacingCars(alwaysMoveRacingCars, CAR_NUMBER, new AlwaysMoveStrategy());
    }

    @Test
    @DisplayName("레이싱 카의 차량대수로 초괴화를 했을 때 리스트의 사이즈가 변하는 것을 확인한다.")
    void initializeRacingCars() {
        assertThat(randomMoveRacingCars.size()).isEqualTo(CAR_NUMBER);
        assertThat(alwaysMoveRacingCars.size()).isEqualTo(CAR_NUMBER);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤무브 레이싱카 게임의 race()를 완료했을 때 racingCar position 은 0 이상 tryNumber 이하 임을 확인한다.")
    void randomMoveRace() {
        RacingCarGame.race(randomMoveRacingCars, TRY_NUMBER);
        for (RacingCar racingCar : randomMoveRacingCars) {
            assertThat(racingCar.getPosition()).isLessThanOrEqualTo(TRY_NUMBER);
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        }
    }

    @RepeatedTest(10)
    @DisplayName("한 번 경주한 랜덤 무브 차들의 위치는 0 또는 1임을 확인한다.")
    void randomMoveRaceOneStep() {
        RacingCarGame.raceOneStep(randomMoveRacingCars);
        for (RacingCar racingCar : randomMoveRacingCars) {
            assertThat(racingCar.getPosition()).isLessThanOrEqualTo(RacingCar.ONE_STEP);
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        }
    }

    @Test
    @DisplayName("항상 움직이는 전략을 사용한 레이싱카 게임의 race()를 완료했을 때 racingCar position 은 모두 tryNumber 임을 확인한다.")
    void alwaysMoveRace(){
        RacingCarGame.race(alwaysMoveRacingCars, TRY_NUMBER);
        for(RacingCar racingCar : alwaysMoveRacingCars){
            assertThat(racingCar.getPosition()).isEqualTo(TRY_NUMBER);
        }
    }

    @Test
    @DisplayName("항상 움직이는 전략을 사용한 레이싱카 게임의 raceOneStep()을 완료했을 때 차의 위치는 1임을 확인한다.")
    void alwaysMoveRaceOneStep(){
        RacingCarGame.raceOneStep(alwaysMoveRacingCars);
        for(RacingCar racingCar : alwaysMoveRacingCars){
            assertThat(racingCar.getPosition()).isEqualTo(RacingCar.ONE_STEP);
        }
    }
}