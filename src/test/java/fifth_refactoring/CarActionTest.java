package fifth_refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import fifth_refactoring.Car;
import fifth_refactoring.CarAction;
import fifth_refactoring.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarActionTest{

    @Test
    @DisplayName("랜덤 값 확인")
    void randomTest(){
        assertThatThrownBy(() -> {
            CarAction.random();
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0~9만 허용");
    }

    @Test
    void moveTest(){
        Car car = new Car();
        car.move();
        assertThat(car.getCarPosition()).isEqualTo(2);
    }
}
