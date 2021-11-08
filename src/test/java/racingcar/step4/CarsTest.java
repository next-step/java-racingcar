package racingcar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step4.domain.Cars;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("값은 0 이하 or 자동차 이름수와 자동차 대수가 맞아야함")
    void inputValidation1(int value) {
        String[] carArr = {"k3", "k5", "K7"};
        assertThatThrownBy(() -> new Cars(carArr, 2))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> new Cars(carArr, 3))
                .doesNotThrowAnyException();
    }

}
