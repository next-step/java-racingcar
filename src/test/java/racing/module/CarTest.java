package racing.module;

import exception.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private final MoveStrategy alwaysTrueStrategy = () -> true;
    private final MoveStrategy alwaysFalseStrategy = () -> false;
    private Car car;

    @BeforeEach
    void setUp() throws CustomException {
        car = new Car("test");
    }

    @Test
    @DisplayName("자동차가 움직이지 않는지 확인")
    void attemptAndDontMove() {
        car.attempt(alwaysFalseStrategy);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 움직이는지 확인")
    void attemptAndMove() {
        car.attempt(alwaysTrueStrategy);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 움직이는지 확인")
    void onlyMove() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름이 맞는지 확인")
    void checkCarName() {
        assertThat(car.getCarName()).isEqualTo("test");
    }
}