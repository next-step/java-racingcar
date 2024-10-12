package racingGame.model.car;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    @DisplayName("생성자 메소드는 자동차 대수가 유효하지 않으면, 에러를 반환한다.")
    public void 생성자_실패_테스트(final String carName) {
        String[] cars = carName.split(",");
        assertThatThrownBy(() -> Cars.newInstance(cars))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "a,b,c,d,e"})
    @DisplayName("생성자 메소드는 자동차 대수가 유효하면, 객체를 반환한다.")
    public void 생성자_성공_테스트(final String carName) {
        String[] carNames = carName.split(",");
        Cars expected = Cars.newInstance(carNames);

        assertThat(expected.getCars().size()).isEqualTo(carNames.length);
    }
}
