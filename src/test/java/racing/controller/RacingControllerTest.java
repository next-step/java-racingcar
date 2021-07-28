package racing.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Name;
import racing.domain.car.Car;
import racing.domain.car.Cars;
import racing.domain.car.FakeBasicCar;
import racing.domain.dto.FakeGameRequest;
import racing.domain.dto.GameRequest;
import racing.domain.dto.GameResponse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingControllerTest {
    @CsvSource(value = {
            "A,B,C|10",
            "A,B,C,D,EEEF|10"
    }, delimiter = '|')
    @DisplayName("gameRun Test")
    @ParameterizedTest
    public void gameRunTest(String carNames, int turnSize) {
        GameRequest gameRequest = new GameRequest(carNames, turnSize);

        GameResponse gameResponse = RacingController.getInstance().gameRun(gameRequest);
        assertThat(gameResponse).isNotNull();
    }


    private Cars newCars(String carNames, Function<Name, Car> carCtor) {
        return new Cars(Arrays.stream(carNames.split("\\|"))
                .map(Name::new)
                .map(carCtor)
                .collect(Collectors.toSet()));
    }

    @DisplayName("racingAllTest")
    @CsvSource(
            "A|B|C|D,E|F,10"
    )
    @ParameterizedTest
    public void racingAllTest(String carNames, String winnerCarNames, int turnSize) {

        Cars cars = newCars(carNames, Car::new);
        Cars fakeCars = newCars(winnerCarNames, FakeBasicCar::new);

        Set<Car> newCarList = new HashSet<>();
        for (Car iCar : cars)
            newCarList.add(iCar);
        for (Car iCar : fakeCars)
            newCarList.add(iCar);

        GameRequest gameRequest = new FakeGameRequest(new Cars(newCarList), turnSize);

        GameResponse gameResponse = RacingController.getInstance().gameRun(gameRequest);
        Cars lastCars = gameResponse.lastValue();

        Cars winners = lastCars.findWinners();
        for (Car iWinner : winners) {
            System.out.println(iWinner);
            assertThat(winnerCarNames.contains(iWinner.toString()))
                    .withFailMessage("에상한 우승자가 포함되어 있지 않음")
                    .isTrue();
        }

        assertThat(winners.size())
                .withFailMessage("에상한 우승자 수와 다름")
                .isEqualTo(winnerCarNames.split("\\|").length);
    }

    @CsvSource({
            "A,0"
    })
    @DisplayName("RacingAll IllegalArgumentException Test")
    @ParameterizedTest
    public void racingAll_IllegalArgumentException_Test(String carNames, int turnSize) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                racingAllTest(carNames, "QQQQ", turnSize)
        );
    }
}