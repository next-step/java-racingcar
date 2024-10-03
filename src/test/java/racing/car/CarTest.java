package racing.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car( 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void 전진_true(int number) {
        assertThat(car.isGo(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = 3)
    void 멈추기_false(int number) {
        assertThat(car.isGo(number)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12})
    void 랜덤값이_0_9사이가_아닐경우(int number) {
        assertThatThrownBy(() -> car.isGo(number)).isInstanceOf(IllegalArgumentException.class);
    }

}
