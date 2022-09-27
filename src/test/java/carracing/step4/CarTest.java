package carracing.step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("test");
    }

    @Test
    @DisplayName("자동차 이동 시 moveNumber가 4 이상일 경우, moveCount가 1 반환")
    void moveTest1() {
        car.move(9);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 시 moveNumber가 4 미만일 경우, moveCount가 0 반환")
    void moveTest2() {
        car.move(1);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("객체 생성 시 name값이 test일 경우, name가 test 반환")
    void getName() {
        assertThat(car.getName()).isEqualTo("test");
    }

}