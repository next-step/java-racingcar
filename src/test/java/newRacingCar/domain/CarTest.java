package newRacingCar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    private Car car;

    @BeforeEach
    void 설정() {
        car = new Car(new Name("min"));
    }

    @Test
    void 자동차_이름_길이_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   Car car = new Car(new Name("minchoi"));
                });
    }

    @Test
    void 자동차_이동_테스트() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void 자동차_멈춤_테스트() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @AfterEach
    void 초기화() {
        car = null;
    }
}
