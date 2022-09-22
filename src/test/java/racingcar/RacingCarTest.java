package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

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

    @Test
    @DisplayName("RacingCar의 move 호출 시 MoveCondition.canMove()에서 true 반환시 position 값 증가")
    void canMove() {
        CanMoveCondition canMoveCondition = new CanMoveCondition();
        RacingCar canMoveRacingCar = new RacingCar();
        then(canMoveRacingCar.getPosition()).isZero();
        canMoveRacingCar.move(canMoveCondition);
        then(canMoveRacingCar.getPosition()).isOne();
    }

    @Test
    @DisplayName("RacingCar의 move 호출 시 MoveCondition.canMove()에서 false 반환시 position 값 변화 없음")
    void cantMove() {
        CantMoveCondition cantMoveCondition = new CantMoveCondition();
        RacingCar cantMoveRacingCar = new RacingCar();
        then(cantMoveRacingCar.getPosition()).isZero();
        cantMoveRacingCar.move(cantMoveCondition);
        then(cantMoveRacingCar.getPosition()).isZero();
    }
}
