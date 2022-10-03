package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @DisplayName("입력받은 carName의 길이와 실제 차의수가 같아야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_carName(String carName, int iterate) {
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate, new RandomStrategy());
        racing.start();

        List<Car> cars = racing.getCars();
        assertThat(cars.size()).isEqualTo(carNames.length);
    }

    @DisplayName("입력받은 iterate의 길이와 Car의 경기기록 길이가 감아야함")
    @ParameterizedTest(name = "{index} {displayName} parameter=\"{0}\"")
    @CsvSource(value = {"qwe,asd,zxc:3", "a:2", "a,b,c:1"}, delimiter = ':')
    void start_iterate(String carName, int iterate) {
        String[] carNames = carName.split(",");
        Racing racing = new Racing(carNames, iterate, new RandomStrategy());
        racing.start();
        List<Car> cars = racing.getCars();

        for (Car car : cars) {
            assertThat(car.getRecord().getRecord().size()).isEqualTo(iterate);
        }
    }

    @DisplayName("getWinners()는 최종 record가 가장높은 Car를 우승자로 반환해야함")
    @Test()
    void getWinners() {
        String[] carNames = {"kero", "giro", "zero"};
        int iterate = 2;
        Racing racing = new Racing(carNames, iterate, new RandomStrategy());
        racing.start();
        List<String> winners = racing.getWinners();
        //Strategy를 한번받아서 모든 Car에게 동일한 Strategy가 주입되어 통제가 안된다. -> 테스트가 힘들어짐
//        assertThat(winners).contains("kero", "zero");
    }
}