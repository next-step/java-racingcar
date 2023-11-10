package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar("test");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "12", "123", "1234", "12345"})
    @DisplayName("RacingCar의 이름은 5자까지 허용한다.")
    void racingCarNameLengthShouldNotExceed5Characters(final String paramCarName) {
        //given
        final RacingCar car = new RacingCar(paramCarName);
        final String carName = car.carName();

        //when
        final int carNameLength = carName.length();

        //then
        assertThat(carNameLength).isLessThanOrEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "12345678", "123456789"})
    @DisplayName("RacingCar의 이름이 6자 이상인 경우, 객체 생성시에 예외가 발생한다.")
    void racingCarNameLengthExceeds6CharactersShouldThrowException(final String paramCarName) {
        //given, when, then
        assertThatThrownBy(() -> new RacingCar(paramCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("RacingCar 객체가 만들어지면, distanceTraveled 변수의 default 값은 0이다.")
    void getDefaultDistanceTraveledValueOnRacingCarCreation() {
        //given
        //when
        int currentDistance = racingCar.currentDistance();

        //then
        assertThat(currentDistance).isEqualTo(0);
    }

    @Test
    @DisplayName("currentDistance 메서드를 사용하면, 자동차의 전진한 거리를 확인한다.")
    void getCurrentDistanceOfRacingCar() {
        //given
        racingCar.moveIfInRange(4);

        //when
        int currentDistance = racingCar.currentDistance();

        //then
        assertThat(currentDistance).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("move 메서드의 입력값으로 0이상 3이하의 값이 들어오면, 자동차는 전진하지 않는다.")
    void moveRacingCar_whenInputInRangeZeroToThree(int moveValue) {
        //given
        int initDistance = racingCar.currentDistance();

        //when
        racingCar.moveIfInRange(moveValue);

        //then
        assertThat(racingCar.currentDistance()).isEqualTo(initDistance);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("move 메서드의 입력값으로 4이상 9이하의 값이 들어오면, 자동차의 전진한 거리가 1 증가한다.")
    void moveRacingCar_whenInputInRangeFourToNine(int moveValue) {
        //given
        int initDistance = racingCar.currentDistance();

        //when
        racingCar.moveIfInRange(moveValue);

        //then
        assertThat(racingCar.currentDistance()).isEqualTo(initDistance + 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"foo:3", "bar:6", "june:9"}, delimiter = ':')
    @DisplayName("toString 메서드를 사용할 경우, 해당 Car의 이름과 distance만큼의 '-'를 출력한다.")
    void getToStringOfRacingCar(String paramCarName, int expectedDistance) {
        //given
        final RacingCar car = getRacingCarWithNameAndDistance(paramCarName, expectedDistance);

        //when
        final String result = car.toString();

        //then
        final String moveDistance = "-".repeat(expectedDistance);
        assertThat(result).isEqualTo(paramCarName + " : " + moveDistance);
    }

    @Test
    @DisplayName("RacingCar를 배열에 넣고 정렬을 하면, distanceTraveled 값에 따라 내림차순으로 정렬이 된다.")
    void sortRacingCarByDistanceTraveledValueDescending() {
        //given
        final RacingCar car1 = getRacingCarWithNameAndDistance("car1", 1);
        final RacingCar car2 = getRacingCarWithNameAndDistance("car2", 2);
        final RacingCar car3 = getRacingCarWithNameAndDistance("car3", 3);

        //when
        final RacingCar[] cars = new RacingCar[]{car1, car2, car3};
        Arrays.sort(cars);

        //then
        assertThat(cars).containsExactly(car3, car2, car1);
    }

    private RacingCar getRacingCarWithNameAndDistance(final String carName, final int moveDistance) {
        final RacingCar car = new RacingCar(carName);
        final int mustMoveValue = 9;

        for (int i = 0; i < moveDistance; i++) {
            car.moveIfInRange(mustMoveValue);
        }

        return car;
    }
}
