package racing.domain;

import org.junit.jupiter.api.Test;
import racing.domain.factory.CarsFactory;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsFactoryTest {
    @Test
    void 인스턴스_생성() {
        Cars cars = CarsFactory.newInstance("CarA, CarB");
        assertThat(cars.equals(new Cars(Arrays.asList(new Car("CarA"), new Car("CarB"))))).isTrue();
    }
}
