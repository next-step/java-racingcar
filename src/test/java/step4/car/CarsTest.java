package step4.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {

    @ParameterizedTest
    @DisplayName("Cars.get()을 호출하면 해당 인덱스의 Car를 리턴한다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void get(String input) {
        String[] carNames = input.split(",");
        Cars cars = new Cars(carNames);

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Name name = car.getName();
            assertEquals(carNames[i], name.getValue());
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
    @DisplayName("가장 많이 이동한 자동차는 한 대 이상 일 수 있다")
    @ValueSource(strings = {"a", "a,a", "a,a,a", "a,a,a,a"})
    void winnerIsMoreThanOne(String input) {
        String[] carNames = input.split(",");
        Cars cars = new Cars(carNames);

        Cars farthestMovedCars = cars.getFarthestMovedCars();

        assertThat(farthestMovedCars.size()).isGreaterThanOrEqualTo(1);
    }
}