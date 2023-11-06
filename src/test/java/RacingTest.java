import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("자동차를 N대 생성한다.")
    void create_cars(int size) {
        Car[] cars = CarFactory.createCars(size);
        assertThat(cars).hasSize(size);
        assertThat(cars).doesNotContainNull();
    }

}
