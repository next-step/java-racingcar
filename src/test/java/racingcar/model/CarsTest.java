package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        this.cars = new Cars(List.of(
                new Car(3),
                new Car(2),
                new Car(1)
        ));
    }

    @Nested
    class getAllPositions_메서드는 {

        @Test
        void 모든_자동차_position_목록을_리턴한다() {
            List<Integer> allPositions = cars.getAllPositions();
            assertThat(allPositions).containsExactly(3, 2, 1);
        }
    }
}
