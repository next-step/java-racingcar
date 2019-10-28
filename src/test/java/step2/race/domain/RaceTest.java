package step2.race.domain;

import org.junit.jupiter.api.Test;
import step2.car.domain.Car;
import step2.car.domain.engine.Engine;
import step2.car.domain.engine.FixedEngine;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private static final int FIRST_HISTORY = 0;

    @Test
    void moveAll_모든_자동차_움직이기() {
        //given
        Engine engine = new FixedEngine(10);
        Car car1 = new Car(engine);
        Car car2 = new Car(engine);
        Race race = new Race(Arrays.asList(car1, car2));

        //when
        race.moveAll();

        //then
        assertThat(race.getRaceHistories().get(FIRST_HISTORY).getHistory()).isEqualTo(Arrays.asList(1, 1));
    }

}