package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차를 생성할 수 있다.")
    @Test
    public void newCarWithNameTest() {
        //given
        Car car = new Car();

        //when & then
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차는 전진 조건이 true일 때만 이동할 수 있다. 전진하면 position이 1씩 증가한다.")
    @Test
    public void carMoveConditionOnTrue() {
        //given
        Car car = new Car().move(true);

        //when & then
        assertThat(car.getPosition()).isEqualTo(1);

        // 1 회 더 전진
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("자동차는 전진하면 포지션이 1씩 증가한다.")
    @Test
    public void test() {
        //given
        Car car1 = new Car().move(true).move(true).move(true);
        Car car2 = new Car().move(true).move(false).move(false);
        Car car3 = new Car().move(false).move(false).move(false);

        //when & then
        assertThat(car1.getPosition()).isEqualTo(3);
        assertThat(car2.getPosition()).isEqualTo(1);
        assertThat(car3.getPosition()).isEqualTo(0);
    }

}
