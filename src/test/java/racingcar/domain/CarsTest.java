package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.TestRacingCarConfig.basicRule;
import static racingcar.TestRacingCarConfig.moveForwardNumberGenerator;
import static racingcar.config.RacingCarException.CAR_NAME_DUPLICATED;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("가장 많이 이동한 자동차가 하나인 경우, 해당 자동차의 이름이 담긴 리스트를 반환한다.")
    void winnerNames_SingleWinner_SingleWinnerName() {
        final String winnerName = "kyle";
        final Car winnerCar = Car.from(winnerName);
        final Car looserCar = Car.from("alex");

        winnerCar.moveForwardOrStop(new MovementStrategy(basicRule(), moveForwardNumberGenerator()));

        final Cars cars = new Cars(List.of(winnerCar, looserCar));

        assertThat(cars.winnerNames())
                .containsOnly(winnerName);
    }

    @Test
    @DisplayName("가장 많이 이동한 자동차가 여럿인 경우, 해당 자동차들의 이름이 담긴 리스트를 반환한다.")
    void winnerNames_MultipleWinners_MultipleWinnerNames() {
        final String winnerName1 = "kyle";
        final Car winnerCar1 = Car.from(winnerName1);

        final String winnerName2 = "alex";
        final Car winnerCar2 = Car.from(winnerName2);

        final Car looserCar = Car.from("haley");

        final MovementStrategy movementStrategy = new MovementStrategy(basicRule(), moveForwardNumberGenerator());

        winnerCar1.moveForwardOrStop(movementStrategy);
        winnerCar2.moveForwardOrStop(movementStrategy);

        final Cars cars = new Cars(List.of(winnerCar1, winnerCar2, looserCar));

        assertThat(cars.winnerNames())
                .containsOnly(winnerName1, winnerName2);
    }

    @Test
    @DisplayName("자동차 객체 목록을 반환하는 메서드를 호출하면, 그에 대한 복사본 목록이 반환된다.")
    void cars_CopyCarList() {
        final String[] carNames = {"kyle", "alex", "haley"};
        final Cars cars = Cars.from(carNames);

        assertThat(cars.cars())
                .hasSize(carNames.length);
    }

    @Test
    @DisplayName("자동차 이름 목록을 통해 자동차들을 생성한다.")
    void from_CarNames_RacingCars() {
        final String[] carNames = {"kyle", "alex", "haley"};

        assertThat(Cars.from(carNames))
                .isNotNull();
    }

    @Test
    @DisplayName("자동차 이름 목록에 중복이 존재한 상태로 자동차들을 생성하는 경우 예외를 던진다.")
    void from_DuplicatedCarNames_Exception() {
        final String[] duplicatedCarNames = {"kyle", "kyle", "alex"};

        assertThatThrownBy(() -> Cars.from(duplicatedCarNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATED.message(duplicatedCarNames));
    }
}
