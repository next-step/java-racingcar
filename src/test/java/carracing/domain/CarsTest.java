package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("자동차 경주에 필요한 자동차들 테스트")
class CarsTest {

    private static final int NUMBER_OF_CARS = 3;
    private static final int MOVABLE_POSITION_NUMBER_PER_MOVEMENT = 1;
    private static final int INITIATION_POSITION_NUMBER = 0;
    private static final int FIRST_MOVING_POSITION_NUMBER = INITIATION_POSITION_NUMBER + MOVABLE_POSITION_NUMBER_PER_MOVEMENT;
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";

    CarNames carNames;

    @BeforeEach
    void setUp() {
        carNames = new CarNames(TEST_CAR_NAMES);
    }

    @DisplayName("조건에 맞는 자동차 이름을 전달했을 때, 자동차들의 생성여부 확인")
    @Test
    void createCarsTest() {
        // when
        Cars cars = new Cars(carNames);
        // then
        assertAll(
                () -> assertThat(cars).isNotNull(),
                () -> assertThat(cars.getCars()).hasSize(TEST_CAR_NAMES.split(CarNames.DELIMITER).length)
        );
    }

    @DisplayName("비어있는 자동차들의 이름을 전달했을 때, 자동차 생성 예외 발생 여부 확인")
    @ParameterizedTest
    @NullSource
    void checkExceptionWithInvalidCarNamesTest(CarNames carNames) {
        // when && then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Cars(carNames)
        );
    }

    @DisplayName("우승한 자동차 검색이 가능한지 확인")
    @Test
    void retrieveWinningCarsTest() {
        // given
        Cars cars = new Cars(carNames);
        // when
        cars = cars.moveCars(() -> true);
        String actual = winningCarNames(cars);
        // then
        assertThat(actual).isEqualTo(TEST_CAR_NAMES);
    }

    @DisplayName("자동차들의 이동이 가능한 경우, 이동했을 때 실제 이동하였는지 확인")
    @Test
    void checkMovableCarsTest() {
        // given
        Cars cars = new Cars(carNames);
        // when
        cars = cars.moveCars(() -> true);
        // then
        assertThat(positionOfCars(cars))
                .hasSize(NUMBER_OF_CARS)
                .containsOnly(FIRST_MOVING_POSITION_NUMBER);
    }

    @DisplayName("자동차들의 이동이 불가능 경우, 이동했을 때 실제 이동하였는지 확인")
    @Test
    void checkUnmovableCarsTest() {
        // given
        Cars cars = new Cars(carNames);
        // when
        cars = cars.moveCars(() -> false);
        // then
        assertThat(positionOfCars(cars))
                .hasSize(NUMBER_OF_CARS)
                .containsOnly(INITIATION_POSITION_NUMBER);
    }

    private String winningCarNames(Cars cars) {
        return cars.retrieveWinningCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.joining(CarNames.DELIMITER));
    }

    private List<Integer> positionOfCars(Cars cars) {
        return cars.getCars()
                .stream()
                .map(Car::getPosition)
                .map(CarPosition::getNumber)
                .collect(Collectors.toList());
    }
}
