package edu.nextstep.racingcar.car;

import edu.nextstep.racingcar.strategy.RacingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;


class RacingCarTest {

     private static class TestStrategy implements RacingStrategy {

        private final boolean bool;

        public TestStrategy(boolean bool) {
            this.bool = bool;
        }

        @Override
        public boolean canMove() {
            return this.bool;
        }
    }

    @Test
    @DisplayName("RacingStrategy 반환값에 따라 RacingCar 의 movedDistance 변경 여부 확인")
    void moveTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // given
        RacingCar racingCar1 = new RacingCar();
        RacingCar racingCar2 = new RacingCar();

        // when
        racingCar1.move(new TestStrategy(true));
        racingCar2.move(new TestStrategy(false));

        // then
        assertThat(racingCar1.getMovedDistance()).isEqualTo(1);
        assertThat(racingCar2.getMovedDistance()).isEqualTo(0);
    }




}