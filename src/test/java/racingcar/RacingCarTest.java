package racingcar;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class RacingCarTest {

    class CanMoveRandomGenerate extends Random {

        @Override
        public int nextInt() {
            return 4;
        }
    }

    class CantMoveRandomGenerate extends Random {

        @Override
        public int nextInt() {
            return 0;
        }
    }

    @Test
    void move() {
        RacingCar cantMoveRacingCar = new RacingCar(new CanMoveRandomGenerate());
        then(cantMoveRacingCar.getPosition()).isZero();
        cantMoveRacingCar.move();
        then(cantMoveRacingCar.getPosition()).isEqualTo(1);
        cantMoveRacingCar.move();
        then(cantMoveRacingCar.getPosition()).isEqualTo(2);
        cantMoveRacingCar.move();
        then(cantMoveRacingCar.getPosition()).isEqualTo(3);
    }

    @Test
    void cantMove() {
        RacingCar cantMoveRacingCar = new RacingCar(new CantMoveRandomGenerate());
        then(cantMoveRacingCar.getPosition()).isZero();
        cantMoveRacingCar.move();
        then(cantMoveRacingCar.getPosition()).isZero();
    }
}
