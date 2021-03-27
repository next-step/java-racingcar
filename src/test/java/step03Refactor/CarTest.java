package step03Refactor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {
    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("car1", 5);
    }

    @Test
    @DisplayName("움직임 테스트")
    void move() {
        car.move(() -> true);
        assertThat(car.getCarPosition()).isEqualTo(6);
    }

    @Test
    @DisplayName("position 비교해서 최대 값에 대한 판단에 대한 테스트")
    void comparePosition() {
        assertThat(car.isWinnerPosition(4)).isEqualTo(true);
        assertThat(car.isWinnerPosition(5)).isEqualTo(true);
        assertThat(car.isWinnerPosition(6)).isEqualTo(false);
    }

    @Test
    @DisplayName("car 이름 출력 테스트")
    void getCarName() {
        assertThat(car.getCarName()).isEqualTo("car1");
    }
}
