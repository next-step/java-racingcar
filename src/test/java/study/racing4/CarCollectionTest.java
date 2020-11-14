package study.racing4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarCollectionTest {

    @Test
    @DisplayName("맥스 포지션 3 확인")
    public void max_포지션_확인() {

        // given
        CarCollection cars = new CarCollection(Arrays.asList(new Car("pobi", 2), new Car("crong", 3)));

        // when
        int maxPosition = cars.getMaxPosition();

        // then
        assertThat(maxPosition).isEqualTo(3);

    }

    @Test
    @DisplayName("우승자 확인")
    public void winner_car_check() {

        // given
        CarCollection cars = new CarCollection(Arrays.asList(new Car("pobi", 2), new Car("crong", 3)));

        // when
        List<Car> matchedCars1 = cars.matchedPositionCars(3);
        List<Car> matchedCars2 = cars.matchedPositionCars(2);

        // then
        assertThat(matchedCars1).contains(new Car("crong", 3));
        assertThat(matchedCars2).contains(new Car("pobi", 2));

    }
}
