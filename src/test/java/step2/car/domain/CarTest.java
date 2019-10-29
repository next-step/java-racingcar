package step2.car.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.car.domain.engine.Engine;
import step2.car.domain.engine.FixedEngine;
import step2.car.domain.engine.RandomEngine;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void getName_자동차에_이름부여() {
        String name = "이름";
        Car car = new Car(name, new RandomEngine());

        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void getPosition_자동차의_현재위치_알려주기() {
        //given
        Engine engine = new FixedEngine(10);
        Car car = new Car("name", engine);

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
        Car car = new Car("name", engine);

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(answer);
    }
}