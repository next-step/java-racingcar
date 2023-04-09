package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;


class CarTest {
    @Test
    void 자동차_전진() {
        // given
        int generatedRandomInteger = 1;
        int movableThreshold = 0;
        Car car = new Car(createMockRandomIntegerGenerator(generatedRandomInteger), movableThreshold);

        // when
        car.moveOrStop();

        // then
        assertThat(car.getMoveStatus()).containsExactly(true);
    }

    @Test
    void 자동차_멈춤() {
        // given
        int generatedRandomInteger = 0;
        int movableThreshold = 1;
        Car car = new Car(createMockRandomIntegerGenerator(generatedRandomInteger), movableThreshold);

        // when
        car.moveOrStop();

        // then
        assertThat(car.getMoveStatus()).containsExactly(false);
    }

    private RandomIntegerGenerator createMockRandomIntegerGenerator(int generated) {
        return () -> generated;
    }
}