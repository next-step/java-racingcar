package racingcar.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    private RacingCar randomMoveRacingCar;
    private RacingCar alwaysMoveRacingCar;
    public static final int tryNumber = 5;

    @BeforeEach
    void setUp() {
        randomMoveRacingCar = new RacingCar(new RandomMoveStrategy());
        alwaysMoveRacingCar = new RacingCar(new AlwaysMoveStrategy());
    }

    @Test
    @DisplayName("레이싱 카 생성 후 시작 위치는 0임을 확인한다.")
    void basePosition() {
        assertThat(randomMoveRacingCar.getPosition()).isEqualTo(RacingCar.BASE_POSITION);
        assertThat(alwaysMoveRacingCar.getPosition()).isEqualTo(RacingCar.BASE_POSITION);
    }

    @RepeatedTest(10)
    @DisplayName("레이싱 카가 랜덤 확률로 움직였을 때 위치는 0 또는 1임을 확인한다.")
    void moveIfMovable() {
        randomMoveRacingCar.moveIfMovable();
        assertThat(randomMoveRacingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        assertThat(randomMoveRacingCar.getPosition()).isLessThanOrEqualTo(RacingCar.ONE_STEP);
    }

    @RepeatedTest(10)
    @DisplayName("레이싱 카가 랜덤 확률로 tryNumber 횟수만큼 움직였을 떄 위치는 0이상 tryNumber 이하임을 확인한다.")
    void moveIfMovableMultiple() {
        for (int i = 0; i < tryNumber; i++) {
            randomMoveRacingCar.moveIfMovable();
        }
        assertThat(randomMoveRacingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        assertThat(randomMoveRacingCar.getPosition()).isLessThanOrEqualTo(tryNumber);
    }

    @Test
    @DisplayName("alwaysMoveRacingCar의 moveIfMoveable함수 실행시 항상 position이 1씩 증가한다.")
    void moveIfMovableByAlwaysMoveRacingCar(){
        alwaysMoveRacingCar.moveIfMovable();
        assertThat(alwaysMoveRacingCar.getPosition()).isEqualTo(RacingCar.ONE_STEP);
    }

    @Test
    @DisplayName("alwaysMove 레이싱 카가 tryNumber 횟수만큼 움직였을 때 위치는 tryNumber임을 확인한다.")
    void moveIfMovableByAlwaysMoveRacingCarMultiple(){
        for(int i=0; i< tryNumber; i++){
            alwaysMoveRacingCar.moveIfMovable();
        }
        assertThat(alwaysMoveRacingCar.getPosition()).isEqualTo(tryNumber);
    }
}