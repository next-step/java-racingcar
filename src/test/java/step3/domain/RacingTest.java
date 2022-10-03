package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @DisplayName("입력받은 carName의 길이와 실제 차의수가 같아야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_carName(String carName, int iterate) {
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate);
        racing.start();
        List<Car> cars = racing.getCars();

        assertThat(cars.size()).isEqualTo(carNames.length);
    }

    @DisplayName("입력받은 iterate의 길이와 Car의 경기기록 길이가 감아야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_iterate(String carName, int iterate) {
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate);
        racing.start();
        List<Car> cars = racing.getCars();

        for (Car car : cars) {
            assertThat(car.getRecord().getRecord().size()).isEqualTo(iterate);
        }
    }

    @DisplayName("getWinners()는 최종 record가 가장높은 Car를 우승자로 반환해야함")
    @Test()
    void getWinners() {
        Car car1 = new Car(new Record(Arrays.asList(1,2)), "kero");
        Car car2 = new Car(new Record(Arrays.asList(0,1)), "giro");
        Car car3 = new Car(new Record(Arrays.asList(1,2)), "zero");
        List<Car> cars = Arrays.asList(car1, car2, car3);
        Racing racing = new Racing(cars, 2);

        assertThat(racing.getWinners()).contains("kero", "zero");
    }
}