package step5.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.car.Car;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동자 이름은 0~5자 사이여야 한다")
    @ValueSource(strings = {"", "a", "aa", "aaa", "aaaa", "aaaaa"})
    void carNameMustBeBetweenZeroAndFour(String carName) {
        assertDoesNotThrow(() -> new Car(carName));
    }

    @ParameterizedTest
    @DisplayName("자동자 이름은 5자를 초과할 수 없다")
    @ValueSource(strings = {"aaaaaa", "aaaaaaa"})
    void carNameMustBeShorterThanFive(String carName) {
        assertThrows(IllegalArgumentException.class, () -> new Car(carName));
    }

}