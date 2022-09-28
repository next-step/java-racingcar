package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"2:3", "0:2", "3:0", "0:0"}, delimiter = ':')
    void start(int carNumber, int iterate) {
        //when
        Racing racing = new Racing(carNumber, iterate);
        racing.start();
        List<Car> cars = racing.getRacingRecordOfCars();

        //then
        assertThat(cars.size()).isEqualTo(carNumber);
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getRacingRecord().size()).isEqualTo(iterate);
        }
        for (Car car : cars) {
            List<Integer> racingRecord = car.getRacingRecord();
            if (racingRecord.size() < 2) {
                break;
            }
            for (int i = 1; i < racingRecord.size(); i++) {
                assertThat(racingRecord.get(i - 1)).isLessThanOrEqualTo(racingRecord.get(i));
            }
        }
    }
}