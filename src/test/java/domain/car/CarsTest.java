package domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 콤마로_구분된_이름만큼_차가_생성된다() {

        // given
        String[] nameOfCars = {"alex", "jake"};

        // when
        Cars result = Cars.make(nameOfCars);

        // then
        assertThat(result.cars()).hasSize(2);
    }
}
