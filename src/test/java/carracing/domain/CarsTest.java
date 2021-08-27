package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("우승자는 position이 가장 높은사람이 선정되어야 한다.")
    void findWinnerTest() {

        // given
        Car car1 = new Car("car1");
        car1.move(5);
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        // when
        List<Car> result = cars.findWinner();

        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(car1);
    }

    @Test
    @DisplayName("우승자가 여러명이면 여러명이 모두 List에 반환될 수 있어야 한다.")
    void findWInnersTest() {

        // given
        Car car1 = new Car("car1");
        car1.move(5);
        Car car2 = new Car("car2");
        car2.move(5);
        Car car3 = new Car("car3");

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        // when
        List<Car> result = cars.findWinner();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(car1);
        assertThat(result).contains(car2);
    }

    @Test
    @DisplayName("중복된 이름의 자동차가 들어오면 exception이 발생해야 한다.")
    void checkDuplicateNameTest() {

        // given
        Car car1 = new Car("car");
        Car car2 = new Car("car");

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Cars(Arrays.asList(car1, car2)))
            .withMessageMatching("차의 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("위치가 다른 중복된 이름의 자동차가 들어오면 exception이 발생해야 한다.")
    void checkDUplicateNameAndPositionTest() {

        // given
        Car car1 = new Car("car");
        Car car2 = new Car("car");
        car2.move(5);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Cars(Arrays.asList(car1, car2)))
            .withMessageMatching("차의 이름은 중복될 수 없습니다.");
    }

}