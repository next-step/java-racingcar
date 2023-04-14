package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipatedCarsTest {

    List<Car> carList;
    @BeforeEach
    void setUpCarList() {
        carList = Arrays.asList(new Car(), new Car(), new Car());
    }
    @Test
    @DisplayName("참가한 자동차량")
    void 참가한자동차_수_3() {
        assertThat(new ParticipatedCars(carList).count()).isEqualTo(3);
    }
    @Test
    void race() {
        new ParticipatedCars(carList).race();
    }
}