package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import race.domain.Car;
import race.domain.CarNames;
import race.domain.Racing;
import race.domain.RacingCars;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {


    @DisplayName("1개 이상의 우승 판단을 제대로 하는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"A,B,C:,:1", "A,B,C:,:3", "A,B,C,D:,:2"}, delimiter = ':')
    void judgeWinnersTest(String strCarNames, String delimiter, int numOfWinner) {
        CarNames carNames = CarNames.createWithDelimiter(strCarNames, delimiter);
        RacingCars cars = RacingCars.createCars(carNames, () -> 1);

        Racing racing = new Racing(cars);
        IntStream.range(0, numOfWinner).forEach(index -> {
            Car winner = cars.get(index);
            winner.move();
        });

        List<Car> winners = racing.judgeWinners();

        assertThat(winners).hasSize(numOfWinner);
        IntStream.range(0, numOfWinner).forEach(index -> {
            Car car = cars.get(index);
            Car winner = winners.get(index);
            assertThat(car).isEqualTo(winner);
        });
    }
}
