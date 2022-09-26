package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MoveCondition;
import racingcar.RacingCar;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarTest {

    class CanMoveCondition implements MoveCondition {

        @Override
        public boolean canMove() {
            return true;
        }
    }

    class CantMoveCondition implements MoveCondition {

        @Override
        public boolean canMove() {
            return false;
        }
    }

    private RacingCar createRacingCar() {
        return new RacingCar("test");
    }

    @Test
    void create() {
        assertThrows(RuntimeException.class, () -> new RacingCar("1"));
        assertThrows(RuntimeException.class, () -> new RacingCar("test"));
        assertThrows(RuntimeException.class, () -> new RacingCar("테스트"));
        assertThrows(RuntimeException.class, () -> new RacingCar("가나다라마"));
    }

    @Test
    @DisplayName("RacingCar 생성시 자동차 이름이 5글자 초과인 경우 에러 발생")
    void validateNameLongerThenFive() {
        assertThrows(RuntimeException.class, () -> new RacingCar("5글자넘어요"));
    }

    @Test
    @DisplayName("RacingCar 생성시 자동차 이름이 비어있는 경우 에러 발생")
    void validateNameIsEmpty() {
        assertThrows(RuntimeException.class, () -> new RacingCar(null));
        assertThrows(RuntimeException.class, () -> new RacingCar(""));
    }

    @Test
    @DisplayName("RacingCar의 move 호출 시 MoveCondition.canMove()에서 true 반환시 position 값 증가")
    void canMove() {
        CanMoveCondition canMoveCondition = new CanMoveCondition();
        RacingCar canMoveRacingCar = createRacingCar();
        then(canMoveRacingCar.getPosition()).isZero();
        canMoveRacingCar.move(canMoveCondition);
        then(canMoveRacingCar.getPosition()).isOne();
    }

    @Test
    @DisplayName("RacingCar의 move 호출 시 MoveCondition.canMove()에서 false 반환시 position 값 변화 없음")
    void cantMove() {
        CantMoveCondition cantMoveCondition = new CantMoveCondition();
        RacingCar cantMoveRacingCar = createRacingCar();
        then(cantMoveRacingCar.getPosition()).isZero();
        cantMoveRacingCar.move(cantMoveCondition);
        then(cantMoveRacingCar.getPosition()).isZero();
    }
}
