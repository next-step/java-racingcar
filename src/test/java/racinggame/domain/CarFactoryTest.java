package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racinggame.domain.CarFactory.createCars;

public class CarFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,pobi"})
    @DisplayName("각 자동차의 이름은 중복될 수 없다")
    void carNamesCannotBeDuplicated(String names) {
        assertThatThrownBy(() -> createCars(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("자동차의 이름은 쉼표(,)를 기준으로 구분한다")
    void carNamesAreSeparatedByComma(String names) {
        List<Car> cars = createCars(names);

        assertThat(cars).hasSize(3);
        assertThat(cars).contains(new Car("pobi"), new Car("crong"), new Car("honux"));
    }

    @Test
    @DisplayName("빈 이름이 포함된 경우 IllegalArgumentException 예외를 발생시킨다")
    void throwException_WhenEmptyNameIncluded() {
        String names = "pobi, ,honux";

        assertThatThrownBy(() -> createCars(names)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5자를 초과하는 이름이 포함된 경우 IllegalArgumentException 예외를 발생시킨다")
    void throwException_WhenNameExceedsFiveCharacters() {
        String names = "pppobi,crong,honux";

        assertThatThrownBy(() -> createCars(names)).isInstanceOf(IllegalArgumentException.class);
    }
}
