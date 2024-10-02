package racingGame.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingGameServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("생성자 메소드는 자동차 대수가 유효할 때, 객체를 생성할 수 있다.")
    public void 생성자_성공_테스트(final int carCount) {
        assertDoesNotThrow(() -> new RacingGameService(carCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    @DisplayName("생성자 메소드는 자동차 대수가 유효하지 않으면, 에러를 반환한다.")
    public void 생성자_실패_테스트(final int carCount) {
        assertThatThrownBy(() -> new RacingGameService(carCount))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3 ,5})
    @DisplayName("moveAllCars 메소드는 자동차 대수 만큼, 객체를 반환한다.")
    public void moveAllCars_메소드_테스트(final int carCount) {
        RacingGameService gameService = new RacingGameService(carCount);

        List<Car> expected = gameService.moveAllCars();

        assertThat(expected).hasSize(carCount);
    }
}
