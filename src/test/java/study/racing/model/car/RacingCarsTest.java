package study.racing.model.car;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarsTest {

    @DisplayName("생성자에 정수가 주어졌을 때 해당 숫자만큼 car가 생성되는지 검증")
    @ParameterizedTest
    @CsvSource({ "1, 1", "100, 100" })
    void createRacingCarsTest(int carCount, int expected) {
        List<String> carNames = getNames(carCount);
        RacingCars racingCars = new RacingCars(carNames);

        assertThat(racingCars.result().size()).isEqualTo(expected);
    }

    private List<String> getNames(int carCount) {
        return IntStream.range(0, carCount)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.toList());
    }
}
