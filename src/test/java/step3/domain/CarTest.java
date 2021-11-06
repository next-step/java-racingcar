package step3.domain;

import org.junit.jupiter.api.Test;

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
    void 자동차가_한칸_전진한다() {
        //given
        Car car = Car.create();
        assertThat(car.getPosition()).isEqualTo(0);
        //when
        car.move();
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
