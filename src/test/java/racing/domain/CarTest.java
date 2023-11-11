package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    void Car_생성() {
        Car car = new Car("abcde");
        assertThat(car.carDistance()).isEqualTo(0);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {new Car("abcdef");});

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {new Car("");});
    }

    @Test
    void Car_이동() {
        Car car = new Car("abcde");
        car.move(() -> true);

        assertThat(car.carDistance()).isEqualTo(1);
    }
}