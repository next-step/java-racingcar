package model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    public void moveStrategy가_null인경우_exception을_던진다() {
        assertThatThrownBy(() -> new Car(null))
            .hasMessageContaining("moveStrategy 가 null입니다.");
    }

    @Test
    public void canMove가_true를_리턴할때_tryMove_정상동작_테스트() {
        Car car = new Car(() -> true);
        car.tryMove();
        assertThat(car.getCurrentPositionDash()).isEqualTo("--");
    }

    @Test
    public void canMove가_false를_리턴할때_tryeMove_정상동작_테스트(){
        Car car = new Car(() -> false);
        car.tryMove();
        assertThat(car.getCurrentPositionDash()).isEqualTo("-");
    }
}
