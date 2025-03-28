import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("생성 오류 테스트")
    public void groupExceptionTest() {
        List<Car> carList = List.of();
        assertThatThrownBy(
            () -> new Cars(carList)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단체 생성 테스트")
    public void groupGenerationTest() {
        List<Car> carList = List.of(
            new Car("pobi"),
            new Car("honux"),
            new Car("brown")
        );
        Cars cars = new Cars(carList);
        assertAll(
            () -> assertThat(cars.cars.get(0).compareTo(cars.cars.get(1))).isEqualTo(0),
            () -> assertThat(cars.cars.get(1).compareTo(cars.cars.get(2))).isEqualTo(0)
        );
    }

}
