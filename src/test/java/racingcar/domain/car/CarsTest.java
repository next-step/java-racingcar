package racingcar.domain.car;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private final List<String> carNames = Lists.newArrayList("damas", "bmw", "benz");

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(new Name(carName)));
        }
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("생성된 자동차의 이름들을 반환한다")
    void should_return_cars_names() {
        //Given & When
        List<String> carNames = cars.getCarNames();

        //Then
        assertThat(carNames).containsAll(this.carNames);
    }

    @Test
    @DisplayName("생성되지 않은 자동차의 이름은 반환하지 않는다")
    void should_not_return_cars_names() {
        //Given & When
        List<String> carNames = cars.getCarNames();

        //Then
        assertThat(carNames).doesNotContain("k5").isNotEmpty();
    }

}