package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void Car_이름이_5글자_이하인경우() {
        Car car = new Car("abcde");
        assertThat(car.name()).isEqualTo("abcde");
    }

    @Test
    void Car_이름이_5글자_초과인경우() {
        Car car = new Car("abcdef");
        assertThat(car.name()).isEqualTo("abcde");
    }

    @Test
    void Car_이름이_비어있는경우() {
        Car car = new Car("");
        assertThat(car.name()).isEqualTo("NoName");
    }

    @Test
    void diceResult가_4이상인경우() {
        Car car = new Car("abcde");
        car.move(4);
        assertThat(car.currentPosition()).isEqualTo(1);
    }

    @Test
    void diceResult가_4미만인경우() {
        Car car = new Car("abcde");
        car.move(3);
        assertThat(car.currentPosition()).isEqualTo(0);
    }

}
