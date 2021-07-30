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
    private static final String[] TEST_CAR_NAMES = {"harris1", "harris2", "harris3"};
    private final List<RacingCar> racingCars = new ArrayList<>();
    public static final int TRY_NUMBER = 10;

    @BeforeEach
    void setUp() {
        RacingCarGame.initializeRacingCars(racingCars, TEST_CAR_NAMES);
    }

    @Test
    @DisplayName("레이싱 카의 차량대수로 초괴화를 했을 때 리스트의 사이즈가 변하는 것을 확인한다.")
    void initializeRacingCars() {
        assertThat(racingCars.size()).isEqualTo(TEST_CAR_NAMES.length);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤무브 레이싱카 게임의 race()를 완료했을 때 racingCar position 은 0 이상 tryNumber 이하 임을 확인한다.")
    void randomMoveRace() {
        RacingCarGame.race(racingCars, TRY_NUMBER, new RandomMoveStrategy());
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isLessThanOrEqualTo(TRY_NUMBER);
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        }
    }

    @RepeatedTest(10)
    @DisplayName("한 번 경주한 랜덤 무브 차들의 위치는 0 또는 1임을 확인한다.")
    void randomMoveRaceOneStep() {
        RacingCarGame.raceOneStep(racingCars, new RandomMoveStrategy());
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isLessThanOrEqualTo(RacingCar.ONE_STEP);
            assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        }
    }

    @Test
    @DisplayName("항상 움직이는 전략을 사용한 레이싱카 게임의 race()를 완료했을 때 racingCar position 은 모두 tryNumber 임을 확인한다.")
    void alwaysMoveRace() {
        RacingCarGame.race(racingCars, TRY_NUMBER, new AlwaysMoveStrategy());
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isEqualTo(TRY_NUMBER);
        }
    }

    @Test
    @DisplayName("항상 움직이는 전략을 사용한 레이싱카 게임의 raceOneStep()을 완료했을 때 차의 위치는 1임을 확인한다.")
    void alwaysMoveRaceOneStep() {
        RacingCarGame.raceOneStep(racingCars, new AlwaysMoveStrategy());
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isEqualTo(RacingCar.ONE_STEP);
        }
    }

    @Test
    @DisplayName("레이싱 카 게임에서 레이싱 카의 위치가 증가했을 때 위너 스코어를 갱신하는 것을 확인한다.")
    void recordWinnerScore(){
        assertThat(RacingCarGame.winnerRecord).isEqualTo(0);
        RacingCarGame.raceOneStep(racingCars, new AlwaysMoveStrategy());
        RacingCarGame.recordWinnerScore(racingCars.get(0));
        assertThat(RacingCarGame.winnerRecord).isEqualTo(1);
    }

    @Test
    @DisplayName("하나의 레이싱카만 움직였을 때 해당 레이싱카가 우승한다.")
    void pickWinners(){
        racingCars.get(0).moveIfMovable(new AlwaysMoveStrategy());
        RacingCarGame.winnerRecord = 1;
        String[] winners = RacingCarGame.pickWinners(racingCars);
        assertThat(winners.length).isEqualTo(1);
        assertThat(winners[0]).isEqualTo(racingCars.get(0).getName());

    }
}