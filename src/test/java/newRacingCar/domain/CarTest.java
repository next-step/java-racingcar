package newRacingCar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class CarTest {

    @Test
    void 자동차_이름_길이_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                   Car car = new Car(new Name("minchoi"));
                });
    }
}
