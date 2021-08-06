package racingcar.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.strategy.AlwaysMoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarTest {
    public static final String TEST_CAR_NAME = "harri";
    private RacingCar racingCar;
    public static final int tryNumber = 5;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar(new Name(TEST_CAR_NAME));
    }

    @Test
    @DisplayName("레이싱카 이름이 5자를 초과하면 IllegalArgumentException이 발생한다.")
    void constructor(){
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCar(new Name("harris"))).withMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("레이싱 카 생성 후 시작 위치는 0임을 확인한다.")
    void basePosition() {
        assertThat(racingCar.getPosition()).isEqualTo(RacingCar.BASE_POSITION);
    }

    @RepeatedTest(10)
    @DisplayName("레이싱 카가 랜덤 확률로 움직였을 때 위치는 0 또는 1임을 확인한다.")
    void moveIfMovable() {
        racingCar.moveIfMovable(new RandomMoveStrategy());
        assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        assertThat(racingCar.getPosition()).isLessThanOrEqualTo(RacingCar.ONE_STEP);
    }

    @RepeatedTest(10)
    @DisplayName("레이싱 카가 랜덤 확률로 tryNumber 횟수만큼 움직였을 떄 위치는 0이상 tryNumber 이하임을 확인한다.")
    void moveIfMovableMultiple() {
        for (int i = 0; i < tryNumber; i++) {
            racingCar.moveIfMovable(new RandomMoveStrategy());
        }
        assertThat(racingCar.getPosition()).isGreaterThanOrEqualTo(RacingCar.BASE_POSITION);
        assertThat(racingCar.getPosition()).isLessThanOrEqualTo(tryNumber);
    }

    @Test
    @DisplayName("alwaysMoveRacingCar의 moveIfMoveable함수 실행시 항상 position이 1씩 증가한다.")
    void moveIfMovableByAlwaysMoveRacingCar(){
        racingCar.moveIfMovable(new AlwaysMoveStrategy());
        assertThat(racingCar.getPosition()).isEqualTo(RacingCar.ONE_STEP);
    }

    @Test
    @DisplayName("alwaysMove 레이싱 카가 tryNumber 횟수만큼 움직였을 때 위치는 tryNumber임을 확인한다.")
    void moveIfMovableByAlwaysMoveRacingCarMultiple(){
        for(int i=0; i< tryNumber; i++){
            racingCar.moveIfMovable(new AlwaysMoveStrategy());
        }
        assertThat(racingCar.getPosition()).isEqualTo(tryNumber);
    }
}