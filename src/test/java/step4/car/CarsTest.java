package step4.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @DisplayName("자동자 이름은 0~4자 사이여야 한다")
    @ValueSource(strings = {",a,bb,ccc,dddd"})
    void carNameMustBeBetweenZeroAndFour(String input) {
        String[] carNames = input.split(",");
        assertDoesNotThrow(() -> new Cars(carNames));
    }

    @ParameterizedTest
    @DisplayName("자동자 이름은 5자를 초과할 수 없다")
    @ValueSource(strings = {"aaaaa,bbbbbb,ccccccc"})
    void carNameMustBeShorterThanFive(String input) {
        String[] carNames = input.split(",");
        assertThrows(IllegalArgumentException.class, () -> new Cars(carNames));
    }

    @ParameterizedTest
    @DisplayName("Cars.get()을 호출하면 해당 인덱스의 Car를 리턴한다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void get(String input) {
        String[] carNames = input.split(",");
        Cars cars = new Cars(carNames);

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String name = car.getName();
            assertEquals(carNames[i], name);
        }
    }

    @ParameterizedTest
    @DisplayName("Cars.size()를 호출하면 Cars의 사이즈를 리턴한다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void size(String input) {
        String[] carNames = input.split(",");
        Cars cars = new Cars(carNames);

        assertEquals(carNames.length, cars.size());
    }

    @ParameterizedTest
    @DisplayName("컬렉션 사이즈보다 큰 인덱스로 get()을 호출하면 에러가 발생한다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void throwsIndexOutOfBoundException(String input) {
        String[] carNames = input.split(",");
        Cars cars = new Cars(carNames);
        int outOfSizeIndex = cars.size();

        assertThrows(IndexOutOfBoundsException.class, () -> cars.get(outOfSizeIndex));
    }

    @ParameterizedTest
    @DisplayName("우승자는 한명 이상 일 수 있다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void winnerIsMoreThanOne(String input) {
        String[] carNames = input.split(",");
        Cars cars = new Cars(carNames);

        assertThat(cars.getFarthestMovedCars()).hasSize(cars.size());
    }
}