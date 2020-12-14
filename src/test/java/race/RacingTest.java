package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.domain.Car;
import race.domain.Racing;
import race.domain.RacingCars;
import race.domain.RacingWinners;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("1개 이상의 우승 판단을 제대로 하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"A,B,C:1", "A,B,C:3", "A,B,C,D:2"}, delimiter = ':')
    void judgeWinnersTest(String strCarNames, int numOfWinner) {
        RacingCars cars = RacingCars.createCars(strCarNames, () -> 1);

        Racing racing = new Racing(cars);
        IntStream.range(0, numOfWinner).forEach(index -> {
            Car winner = cars.get(index);
            winner.move();
        });

        RacingWinners winners = racing.judgeWinners();

        List<Car> winnerCars = IntStream.range(0, numOfWinner)
                .mapToObj(cars::get).collect(Collectors.toList());

        assertThat(winners.isWinners(winnerCars)).isTrue();
    }
}
