package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 테스트")
class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @DisplayName("move() 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 1, 7})
    void move(int count) {
        for (int i = 0; i < count; i++) {
            car.move();
        }
        assertThat(car.getCurrentPosition()).isEqualTo(count);
    }
}
