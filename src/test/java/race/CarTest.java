package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    public Car car;

    @BeforeEach
    void setCar() {
        this.car = new Car("car");
    }

    @AfterEach
    void clearCar() {
        this.car = null;
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 이동_시_0_이상_4_이하_난수에는_이동하지_않는다(int randomNumber) {
        car.accelerate(randomNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void 이동_시_5_이상_9_이하_난수에는_전진한다(int randomNumber) {
        car.accelerate(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "10,10"})
    void 자동차의_현재_위치를_구한다(int round, int expectedPosition) {
        for (int i = 0; i < round; i++) {
            car.accelerate(5);
        }

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "5chars", "5글자이상차"})
    void 자동차_이름은_1자_이상_5자_이하이다(String input) {
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1~5자까지 가능합니다. : "+ input);
    }
}