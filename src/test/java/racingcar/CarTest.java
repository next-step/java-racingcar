package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest(name = "4 이상이 나오면 1칸 전진해야 한다. {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void testCarShouldGoWhenRandomNumberIsGreaterOrEqualTo3(int randomNumber) {
        // Given
        Car car = new Car();
        int firstPosition = car.getPosition();

        // When
        car.run(new RandomNumber(randomNumber));

        // Then
        assertThat(car.getPosition()).isEqualTo(firstPosition + 1);
    }

    @ParameterizedTest(name = "4 미만이 나오면 전진할 수 없다. {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void testCarShouldGoWhenRandomNumberIsLessThan4(int randomNumber) {
        // Given
        Car car = new Car();
        int firstPosition = car.getPosition();

        // When
        car.run(new RandomNumber(randomNumber));

        // Then
        assertThat(car.getPosition()).isEqualTo(firstPosition);
    }

    @Test
    @DisplayName("자동차는 이름을 가질 수 있다")
    void testCarCanHaveName() {
        // Given
        Car car1 = new Car("same-name");
        Car car2 = new Car("different-name");

        // When & Then
        assertThat(car1).isEqualTo(new Car("same-name"));
        assertThat(car2).isNotEqualTo(new Car("same-name"));
    }
}
