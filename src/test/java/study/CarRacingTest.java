package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.CarRacing;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private static CarRacing carRacing;

    @BeforeEach
    void 셋업() {
        carRacing = new CarRacing(3, 3);
    }

    @Test
    void 출전할_자동차_수() {
        assertThat(carRacing.carsCount()).isEqualTo(3);
    }

    @Test
    void 총_라운드_수() {
        assertThat(carRacing.rounds()).isEqualTo(3);
    }
}
