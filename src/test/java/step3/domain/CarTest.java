package step3.domain;

import org.junit.jupiter.api.Test;
import step3.service.MoveNumberGenerator;
import step3.service.NonMoveNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 자동차를_생성한다() {
        //given
        Car car = Car.create();
        //when & then
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차를_생성하면_위치_상태는_0이다() {
        //given
        Car car = Car.create();
        //when & then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤_값이_4이상이면_한칸_전진한다() {
        //given
        Car car = Car.create();
        assertThat(car.getPosition()).isEqualTo(0);
        //when
        car.move(new MoveNumberGenerator());
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값이_4미만이면_정지한다() {
        //given
        Car car = Car.create();
        assertThat(car.getPosition()).isEqualTo(0);
        //when
        car.move(new NonMoveNumberGenerator());
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
