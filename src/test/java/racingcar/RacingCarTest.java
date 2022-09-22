package racingcar;

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
    void move() {
        CanMoveCondition canMoveCondition = new CanMoveCondition();
        RacingCar cantMoveRacingCar = new RacingCar();
        then(cantMoveRacingCar.getPosition()).isZero();
        cantMoveRacingCar.move(canMoveCondition);
        then(cantMoveRacingCar.getPosition()).isEqualTo(1);
        cantMoveRacingCar.move(canMoveCondition);
        then(cantMoveRacingCar.getPosition()).isEqualTo(2);
        cantMoveRacingCar.move(canMoveCondition);
        then(cantMoveRacingCar.getPosition()).isEqualTo(3);
    }

    @Test
    void cantMove() {
        CantMoveCondition cantMoveCondition = new CantMoveCondition();

        RacingCar cantMoveRacingCar = new RacingCar();
        then(cantMoveRacingCar.getPosition()).isZero();
        cantMoveRacingCar.move(cantMoveCondition);
        then(cantMoveRacingCar.getPosition()).isZero();
    }
}
