package edu.nextstep.racingcarwinner.domain;

import edu.nextstep.racingcarwinner.strategy.RacingStrategy;
import edu.nextstep.racingcarwinner.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void create() {
        // given
        String name = "hwan";

        // when
        Car car = new Car("hwan");

        // then
        assertThat(car).isEqualTo(new Car("hwan", 0));
    }

    @Test
    void moveSuccess() {
        // given
        String name = "hwan";
        Car car = new Car(name);

        // when
        car.move(() -> true); // 아래 moveFail() 에서의 정책을 lambda 로 나타내면 좌측과 같이 나타낼 수 있다.

        // then
        assertThat(car.getName()).isEqualTo("hwan");
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void moveFail() {
        // given
        String name = "hwan";
        Car car = new Car(name);

        // when
        RacingStrategy racingStrategy = new RandomStrategy(){
            @Override
            public boolean movable() {
                return false;
            }
        };
        car.move(racingStrategy);

        // then
        assertThat(car.getName()).isEqualTo("hwan");
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
