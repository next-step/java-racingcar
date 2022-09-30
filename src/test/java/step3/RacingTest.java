package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @DisplayName("입력받은 carName의 길이와 실제 차의수가 같아야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_carName(String carName, int iterate) {
        //when
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate);
        racing.start();
        List<String> winners = racing.getWinners();
        List<Car> cars = racing.getRacingRecordOfCars();

        //then
        assertThat(cars.size()).isEqualTo(carNames.length);
    }

    @DisplayName("입력받은 iterate의 길이와 Car의 경기기록 길이가 감아야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_iterate(String carName, int iterate) {
        //when
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate);
        racing.start();
        List<String> winners = racing.getWinners();
        List<Car> cars = racing.getRacingRecordOfCars();

        //then
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getRacingRecord().size()).isEqualTo(iterate);
        }
    }

    @DisplayName("Car의 각 라운드의 경기기록은 1씩증가하거나 이전기록과 같다")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_record_validate(String carName, int iterate) {
        //when
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate);
        racing.start();
        List<String> winners = racing.getWinners();
        List<Car> cars = racing.getRacingRecordOfCars();

        //then
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