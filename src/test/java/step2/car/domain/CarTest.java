package step2.car.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.car.domain.engine.Engine;
import step2.car.domain.engine.FixedEngine;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void getPosition_자동차의_현재위치_알려주기() {
        //given
        Engine engine = new FixedEngine(10);
        Car car = new Car(engine);

        //then
        assertThat(car.getPosition()).isEqualTo(0);

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "5:1"}, delimiter = ':')
    void move_4이상의_값을_받아야_움직인다(Integer power, Integer answer) {
        //given
        Engine engine = new FixedEngine(power);
        Car car = new Car(engine);

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(answer);
    }
}