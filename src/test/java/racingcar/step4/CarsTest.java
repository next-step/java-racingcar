package racingcar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step4.domain.Car;
import racingcar.step4.domain.Cars;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("값은 0 이하 값이 들어오면 안된다")
    void inputValidation(int value) {
        assertThatThrownBy(() -> new Cars("K3", value))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> new Cars("K3", 1))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"k3", "k5", "k7"})
    @DisplayName("자동차 이름을 구분자로 쪼개기")
    void nameSplit(String name) {
        Cars cars = new Cars("k3,k5,k7", 3);
        assertThat(cars.getCars().contains(new Car(name))).isTrue();
    }

}
