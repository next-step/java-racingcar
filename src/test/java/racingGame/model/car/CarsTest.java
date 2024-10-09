package racingGame.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("생성자 메소드는 자동차 대수가 유효하지 않으면, 에러를 반환한다.")
    public void 생성자_실패_테스트(final int carCount) {
        assertThatThrownBy(() -> Cars.createCars(carCount))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    @DisplayName("생성자 메소드는 자동차 대수가 유효하면, 객체를 반환한다.")
    public void 생성자_성공_테스트(final int carCount) {
        Cars expected = Cars.createCars(carCount);

        assertThat(expected.getCars().size()).isEqualTo(carCount);
    }
}
