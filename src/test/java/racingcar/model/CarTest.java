package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 차_생성시_위치는_0이다() {
        Car car = new Car("a");

        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @Test
    void 숫자가_4이상이면_차가_전진한다() {
        Car car = new Car("a");

        car.move(4);

        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @Test
    void 숫자가_4미만이면_차가_멈춘다() {
        Car car = new Car("a");

        car.move(3);

        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @Test
    void 숫자가_음수면_차가_멈춘다() {
        Car car = new Car("a");

        car.move(-3);

        assertThat(car.currentPosition()).isEqualTo(0);
    }

    @Test
    void 차_생성_빈값() {
        assertThatThrownBy(() ->
               new Car("")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_이름_5자_이하면_생성() {
        Car car = new Car("test");

        assertThat(car).isEqualTo(new Car("test"));
    }
    @Test
    void 차_이름_5자_초과하면_에러() {
        assertThatThrownBy(() ->
               new Car("test12")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차_현재_위치(){
        Car car = new Car("test", new Position(4));

        assertThat(car.currentPosition()).isEqualTo(4);
    }

    @Test
    void 차_최대값_구하기(){
        Car car = new Car("test", new Position(4));

        assertThat(car.max(5)).isEqualTo(5);
    }


    @Test
    void 차_우승자인지(){
        Car car = new Car("test", new Position(4));

        assertThat(car.isWineer(4)).isTrue();
    }

}
