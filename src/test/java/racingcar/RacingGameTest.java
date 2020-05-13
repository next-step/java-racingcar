package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingGameTest {

    @DisplayName("n대의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"5,true", "5,false"})
    void canMoveRacingCar(int numberOfCar, boolean canMove) {
        RacingGame racingGame = new RacingGame(
            getRacingCars(numberOfCar, canMove)
        );

        racingGame.tryMove();

        racingGame.getPositions()
            .forEach(integer -> assertThat(integer).isEqualTo(canMove ? 1 : 0));
    }

    @DisplayName("n개의 자동차의 위치를 알수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void getPositions(int numberOfCar) {
        RacingGame racingGame = RacingGameFactory.newRacingGame(numberOfCar);
        assertThat(racingGame.getPositions().size()).isEqualTo(numberOfCar);
    }

    private RacingCars getRacingCars(int numberOfCar, boolean canMove) {
        return new RacingCars(
            IntStream.range(0, numberOfCar)
                .mapToObj(value -> new Car(() -> canMove))
                .collect(Collectors.toList())
        );
    }


}
