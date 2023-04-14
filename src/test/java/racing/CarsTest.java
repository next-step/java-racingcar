package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차들의 위치배열 반환테스트")
    @ValueSource(ints = {1,2,10})
    void valueOfCarsPositionTest(int carCount) {
        Cars cars = new Cars(Arrays.asList(new Car(), new Car(4), new Car(1), new Car(0)));
        List<Integer> carsPosition = cars.valueOfCarsPosition();
        assertThat(cars.getCarList()).hasSize(4);
        assertThat(carsPosition).containsExactly(0, 4, 1, 0);
    }
}
