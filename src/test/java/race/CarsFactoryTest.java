package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsFactoryTest {
    @Test
    void 쉼표로_구분된_문자열과_이동전략으로부터_car_여러개를_만들_수_있다() {
        Cars cars = CarsFactory.makeCars("a,b,c", new TestHelper.AlwaysMoveStrategy());
        assertThat(cars.getCarList()
                .stream()
                .map(it -> it.getCarName().getCarName())
                .toArray()
        ).contains("a", "b", "c");
    }
}
