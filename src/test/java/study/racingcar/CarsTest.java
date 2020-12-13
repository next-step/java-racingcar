package study.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    @ParameterizedTest
    @CsvSource(value = {"2, 0", "3, 0", "4, 1", "5, 1"})
    public void moveAll_test(int randomNo, int resultPosition) throws Exception {
        //Given
        Cars cars = new Cars(5);

        //When
        cars.moveAll(randomNo);

        //Then
        RacingResult result = cars.getResult();
        List<Car> results = result.getResults();

        results.forEach(car ->
            assertThat(car.getPosition()).isEqualTo(resultPosition));

    }

}
