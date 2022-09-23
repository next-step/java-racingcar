package study;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.CarRacing;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private static CarRacing carRacing;

    @BeforeEach
    public void 셋업() {
        carRacing = new CarRacing(3);
    }

    @Test
    public void 출전할_자동차_수() {
        assertThat(carRacing.carsCount()).isEqualTo(3);
    }
}
