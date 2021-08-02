package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("자동차 경주 테스트")
class RacingTest {

    private Racing racing;
    private List<RacingRecords> racingRecordsList;

    @BeforeEach
    void setUp() {
        String[] carNames = {"bmw", "benz", "audi"};
        MoveStrategy moveStrategy = () -> true;
        racing = new Racing(carNames, moveStrategy);
        racingRecordsList = racing.start(5);
    }

    @Test
    @DisplayName("자동차 경주 우승자 확인")
    void racingCarWinnerCheck() {
        List<String> racingWinner = racingRecordsList.get(4).getRacingWinner();
        assertThat(racingWinner).contains("benz", "audi", "audi");
    }

    @Test
    @DisplayName("자동차 경주 완료후 첫번재 자동차 위치 확인")
    void racingCarPositionCheck() {
        RacingRecord racingRecord = racingRecordsList.get(4).getRacingRecords().get(0);
        int firstCarFinalPosition = racingRecord.getPosition();

        assertThat(firstCarFinalPosition).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 경주에 참여하는 자동차 대수 확인")
    void racingCarCountCheckTest() {
        assertThat(racing.getRacingCars().length).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 경주에서 주어진 횟수 만큼 경주내역이 기록되는지 확인")
    void racingHistoryCheckTest() {
        assertThat(racingRecordsList.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 경주내역에 올바른 자동차 대수가 기록되는지 확인")
    void racingHistoryCheckForCarCountTest() {
        assertThat(racingRecordsList.get(0).getRacingRecords().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 경주내역에 자동차 순서가 알맞게 기록되는지 확인")
    void racingHistoryOrderCheckTest() {
        Car car1 = racingRecordsList.get(0).getRacingRecords().get(1).getCar();
        Car car2 = racingRecordsList.get(1).getRacingRecords().get(1).getCar();
        Car car3 = racingRecordsList.get(2).getRacingRecords().get(1).getCar();

        assertThat(car1).isEqualTo(car2).isEqualTo(car3);
    }

    @Test
    @DisplayName("자동차 이름이 순서대로 잘 등록되었는지 확인")
    void racingHistoryCarNameOrderTest() {

        String carName1 = racingRecordsList.get(0).getRacingRecords().get(0).getCar().getName();
        String carName2 = racingRecordsList.get(0).getRacingRecords().get(1).getCar().getName();
        String carName3 = racingRecordsList.get(0).getRacingRecords().get(2).getCar().getName();

        assertAll(
                () -> assertThat(carName1).isEqualTo("bmw"),
                () -> assertThat(carName2).isEqualTo("benz"),
                () -> assertThat(carName3).isEqualTo("audi")
        );
    }
}