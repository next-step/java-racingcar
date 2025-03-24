package model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    public void canMove가_true를_리턴할때_tryMove_정상동작_테스트() {
        Car car = new Car("cheol", () -> true);
        car.tryMove();
        assertThat(car.getCurrentPosition()).isEqualTo(2);
    }

    @Test
    public void canMove가_false를_리턴할때_tryeMove_정상동작_테스트(){
        Car car = new Car("cheol", () -> false);
        car.tryMove();
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    public void car_name의_길이는_5자를_넘을수없다(){
        assertThatThrownBy(() -> new Car("charles", null))
            .hasMessageContaining("name은 5자를 초과할 수 없습니다.");

    }
}
