package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    @Test
    void from() {
        Assertions.assertThat(Cars.from(5).getCarList().size())
                .isEqualTo(5);
    }
}