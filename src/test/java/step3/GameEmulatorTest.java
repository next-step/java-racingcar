package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;
import step3.domain.RacingGame;
import step3.view.GameEmulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GameEmulatorTest {
    @ParameterizedTest
    @CsvSource(value = {"kyd | 5", "kyd, one | 7", "kyd, one, two | 8"}, delimiter = '|')
    void racingAll(String namesOfCarsText, int numberOfAttempts) {

        RacingGame racingGame = new RacingGame(namesOfCarsText, numberOfAttempts);

        GameEmulator.getResult(racingGame);

        assertThat(racingGame.getRound()).isEqualTo(numberOfAttempts);
    }

    @Test
    void champion() {
        List<Car> cars = new ArrayList<Car>() {{
            add(new Car("one", 1));
            add(new Car("two", 2));
        }};

        Car winner = new Car("win", 10);

        cars.add(winner);

        assertThat(GameEmulator.getChampions(cars)).containsExactly(winner);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5"}, delimiter = ',')
    void championWithSamePosition(int count) {
        assertThat(
                GameEmulator.getChampions(
                        IntStream.rangeClosed(1, count)
                                .limit(count)
                                .mapToObj(position -> new Car(String.valueOf(position), position))
                                .collect(Collectors.toList()))
        ).hasSize(count);
    }
}