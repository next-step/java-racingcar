package carracing.domain.car;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void newObject_emptyCars_throwsException() {
        List<Car> emptyCars = new ArrayList<>();

        assertThatThrownBy(() -> new Cars(emptyCars))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
