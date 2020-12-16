package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(2);
    }
    @Test
    @DisplayName("moveRule의 결과에 따라 모든 Car들이 잘 이동했는지 확인한다.")
    void moveAll_true() {
        cars.moveAll(1, () -> true);

        assertThat(cars.getValue().get(0).getDistance()).isEqualTo(1);
        assertThat(cars.getValue().get(1).getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("moveRule의 결과에 따라 모든 Car들이 잘 이동했는지 확인한다.")
    void moveAll_false() {
        cars.moveAll(1, () -> false);

        assertThat(cars.getValue().get(0).getDistance()).isEqualTo(0);
        assertThat(cars.getValue().get(1).getDistance()).isEqualTo(0);
    }
}
