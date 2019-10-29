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
        Car car1 = new Car("name1", engine);
        Car car2 = new Car("name2", engine);
        Race race = new Race(Arrays.asList(car1, car2));

        //when
        assertThat(race.getRaceHistories()).hasSize(0);
        race.moveAll();

        //then
        assertThat(race.getRaceHistories()).hasSize(1);
        assertThat(race.getRaceHistories().get(FIRST_HISTORY).getHistory()).hasSize(2);
    }

}