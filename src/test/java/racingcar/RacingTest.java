package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RacingRecords;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("자동차 경주 테스트")
class RacingTest {

    private Racing racing;
    private List<RacingRecords> racingRecords;

    @BeforeEach
    void setUp() {
        String[] carNames = {"bmw", "benz", "audi"};
        racing = new Racing(carNames);
        racingRecords = racing.start(5);
    }

    @Test
    @DisplayName("자동차 경주에 참여하는 자동차 대수 확인")
    void racingCarCountCheckTest() {
        assertThat(racing.getRacingCars().length).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 경주에서 주어진 횟수 만큼 경주내역이 기록되는지 확인")
    void racingHistoryCheckTest() {
        assertThat(racingRecords.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 경주내역에 올바른 자동차 대수가 기록되는지 확인")
    void racingHistoryCheckForCarCountTest() {
        assertThat(racingRecords.get(0).getRacingRecords().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 경주내역에 자동차 순서가 알맞게 기록되는지 확인")
    void racingHistoryOrderCheckTest() {
        Car car1 = racingRecords.get(0).getRacingRecordsInCar(1);
        Car car2 = racingRecords.get(1).getRacingRecordsInCar(1);
        Car car3 = racingRecords.get(2).getRacingRecordsInCar(1);

        assertThat(car1).isEqualTo(car2).isEqualTo(car3);
    }

    @Test
    @DisplayName("자동차 이름이 순서대로 잘 등록되었는지 확인")
    void racingHistoryCarNameOrderTest() {
        String carName1 = racingRecords.get(0).getRacingRecordsInCar(0).getName();
        String carName2 = racingRecords.get(0).getRacingRecordsInCar(1).getName();
        String carName3 = racingRecords.get(0).getRacingRecordsInCar(2).getName();

        assertAll(
                () -> assertThat(carName1).isEqualTo("bmw"),
                () -> assertThat(carName2).isEqualTo("benz"),
                () -> assertThat(carName3).isEqualTo("audi")
        );
    }
}