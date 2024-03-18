package carRacingWinner.test;

import carRacingWinner.entity.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    @DisplayName("차량 이름길이 확인")
    public void nameLength() {

        String name = "fuma";
        assertThrows(IllegalArgumentException.class, () -> new Car("sonata"));
        assertThat(new Car("fuma").getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("랜덤값 테스트")
    public void carMoveChange() {
        Car car = new Car("dobi") {
            @Override
            protected int moveChance() {
                return 5;
            }
        };
        car.move();
        car.move();
        assertThat(car.getLocation()).isEqualTo(2);
    }
}
