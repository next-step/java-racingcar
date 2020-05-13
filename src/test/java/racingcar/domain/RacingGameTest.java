package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.RacingGameFactory;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;

public class RacingGameTest {

    @DisplayName("n대의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"true", "false"})
    void canMoveRacingCar(boolean canMove) {
        List<String> names = Arrays.asList("car1","car2","car3");

        RacingGame racingGame = new RacingGame(getRacingCars(names, canMove));
        racingGame.tryMove();

        racingGame.getCars()
            .forEach(car -> assertThat(car.getPosition()).isEqualTo(canMove ? 1 : 0));
    }

    @DisplayName("n개의 자동차의 이름과 위치를 알수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void getPositions(String carNames) {
        List<String> names = Arrays.asList(carNames.split(","));
        RacingGame racingGame = createRacingGame(carNames);

        List<Car> cars = racingGame.getCars();
        for (int i = 0; i < names.size() ; i++){
            assertThat(cars.get(i).getName()).isEqualTo(names.get(i));
            assertThat(cars.get(i).getPosition()).isEqualTo(0);
        }

        assertThat(racingGame.getCars().size()).isEqualTo(names.size());
    }

    @DisplayName("우승자를 조회 할수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    void getWinners(String carNames) {
        RacingGame racingGame = createRacingGame(carNames);
        racingGame.tryMove();

        int max= racingGame.getCars().stream().map(Car::getPosition).max(Integer::compareTo).orElse(0);

        racingGame.getWinners().forEach(car -> assertThat(car.getPosition()).isEqualTo(max));
    }

    private RacingCars getRacingCars(List<String> names, boolean canMove) {
        return new RacingCars(
            names.stream()
                .map(s -> new Car(() -> canMove))
                .collect(Collectors.toList())
        );
    }

    private RacingGame createRacingGame(String carNames){
        List<String> names = Arrays.asList(carNames.split(","));
        return  RacingGameFactory.newRacingGame(names);
    }


}
