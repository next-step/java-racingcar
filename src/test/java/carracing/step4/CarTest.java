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
    @DisplayName("Move 테스트 : moveNumber 9 : 결과 1")
    void moveTest1() {
        car.move(9);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("Move 테스트 : moveNumber 1 : 결과 0")
    void moveTest2() {
        car.move(1);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("Name 테스트 : name 'test' : 결과 'test'")
    void getName() {
        car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");
    }

}