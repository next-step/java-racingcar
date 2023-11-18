package car.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    private Car car;
    private static final int START_DISTANCE = 0;

    @BeforeEach
    void setUp() {
        car = new Car(START_DISTANCE, "car");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 랜덤숫자가_4미만이면_멈추는지_테스트(int randomNumber) {
        car.game(randomNumber);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 랜덤숫자가_4이상이면_전진하는지_테스트(int randomNumber) {
        car.game(randomNumber);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
