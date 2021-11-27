package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("가장 멀리간 자동차가 우승한다")
    void testFindWinnerOne() {
        // Given
        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        Car test3 = new Car("test3");
        Cars cars = new Cars(Arrays.asList(test1, test2, test3));
        test1.run(() -> true);

        // When
        List<Car> winners = cars.getWinners();

        // Then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).containsOnly(test1);
    }

    @Test
    @DisplayName("가장 멀리간 자동차가 여러대일 수 있다")
    void testFindWinners() {
        // Given
        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        Car test3 = new Car("test3");
        Cars cars = new Cars(Arrays.asList(test1, test2, test3));
        test1.run(() -> true);
        test2.run(() -> true);

        // When
        List<Car> winners = cars.getWinners();

        // Then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsOnly(test1, test2);
    }

    @Test
    @DisplayName("Cars가 갖고있는 Car들을 List 형태로 반환할 수 있다")
    void testGetList() {
        // Given
        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        Car test3 = new Car("test3");
        Cars cars = new Cars(Arrays.asList(test1, test2, test3));

        // When
        List<Car> actual = cars.getList();

        // Then
        assertThat(actual).containsOnly(test1, test2, test3);
    }
}