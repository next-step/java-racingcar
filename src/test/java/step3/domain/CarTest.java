package step3.domain;

import org.junit.jupiter.api.Test;
import step3.service.MoveNumberGenerator;
import step3.service.NonMoveNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 자동차를_생성한다() {
        //given
        String name = "java";
        Car car = Car.create(name);
        //when & then
        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_이름_길이가_5자_초과면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Car.create("spring"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차를_생성하면_위치_상태는_0이다() {
        //given
        Car car = Car.create("java");
        //when & then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 랜덤_값이_4이상이면_한칸_전진한다() {
        //given
        Car car = Car.create("java");
        assertThat(car.getPosition()).isEqualTo(0);
        //when
        car.move(new MoveNumberGenerator());
        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값이_4미만이면_정지한다() {
        //given
        Car car = Car.create("java");
        assertThat(car.getPosition()).isEqualTo(0);
        //when
        car.move(new NonMoveNumberGenerator());
        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
