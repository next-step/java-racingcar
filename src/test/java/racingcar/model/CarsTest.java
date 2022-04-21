package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.strategy.FixedTrueMovingStrategy;
import racingcar.strategy.RandomMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    private static final String MINIMUM_NUMBER_OF_CAR_NAMES_INPUT_ERR_MSG = "자동차는 1대 이상 입력되어야 합니다.";

    private Cars cars;
    @BeforeEach
    void beforeEach() {
        cars = Cars.create(new FixedTrueMovingStrategy(), "pobi,crong,honux");
    }

    @Test
    @DisplayName("자동차 객체 생성 확인")
    void confirmCarObjectCreation() {
        List<Car> result = cars.getCars();

        assertThat(result).hasSize(3);
    }

    @Test
    @DisplayName("자동차 경주 우승자 찾기")
    void findCarRacingWinner() {
        List<Car> participateCars = cars.getCars();
        participateCars.get(0).move();

        List<String> result = cars.getWinnerNames();

        assertThat(result).containsExactly("pobi");
    }

    @Test
    @DisplayName("자동차 경주 다수의 우승자 찾기")
    void findCarRacingMultipleWinner() {
        List<Car> participateCars = cars.getCars();
        for (Car participateCar : participateCars) {
            participateCar.move();
        }

        List<String> result = cars.getWinnerNames();

        assertThat(result).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("입력받은 자동차 이름들을 콤마(,)로 자르기")
    void separatorOfInputCarNames() {
        assertThat(Cars.separateInputCars("pobi,crong,honux")).contains("pobi", "crong", "honux");
    }

    @ParameterizedTest
    @DisplayName("입력된 자동차의 갯수가 1 미만인 경우 예외발생")
    @NullAndEmptySource
    void checkTheNumberOfEnteredCars(String value) {
        assertThatThrownBy(() -> Cars.checkTheNumberOfInputCars(value))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(MINIMUM_NUMBER_OF_CAR_NAMES_INPUT_ERR_MSG);
    }
}
