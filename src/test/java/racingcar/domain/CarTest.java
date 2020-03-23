package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차를 생성할 수 있다.")
    @Test
    public void newCarWithNameTest() {
        //given
        Car car = new Car("정원");

        //when & then
        assertThat(car).isNotNull();
    }

    @DisplayName("자동차는 전진 조건이 true일 때만 이동할 수 있다. 전진하면 position이 1씩 증가한다.")
    @Test
    public void carMoveConditionOnTrue() {
        //given
        Car car = new Car("정원").move(true);

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
        Car 정원 = new Car("정원").move(true).move(true).move(true);
        Car 자바 = new Car("자바").move(true).move(false).move(false);
        Car 레이서 = new Car("레이서").move(false).move(false).move(false);

        //when & then
        assertThat(정원.getPosition()).isEqualTo(3);
        assertThat(자바.getPosition()).isEqualTo(1);
        assertThat(레이서.getPosition()).isEqualTo(0);
    }

}
