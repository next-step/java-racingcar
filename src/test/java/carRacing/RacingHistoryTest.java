package carRacing;

import carRacing.domain.Car;
import carRacing.domain.RacingHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingHistoryTest {

    private RacingHistory getTestRacingHistory() {
        RacingHistory racingHistory = new RacingHistory();

        List<Car> carList = Arrays.asList(new Car("win"), new Car("lose"));
        racingHistory.doRecord(1, carList);
        carList.get(0).run(4);
        racingHistory.doRecord(2, carList);

        return racingHistory;
    }

    @Test
    @DisplayName("N 라운드의 경기 히스토리 조회 테스트")
    void getRecordList() {
        assertThat(getTestRacingHistory().getRecordList(1).size()).isEqualTo(2);
    }


    @Test
    @DisplayName("마지막 라운드를 조회 테스트")
    void getLastRound() {
        assertThat(getTestRacingHistory().getLastRound()).isEqualTo(2);
    }

    @Test
    @DisplayName("1명의 승리자 조회 테스트")
    void getWinnerRecordList1() {
        assertThat(getTestRacingHistory().getWinnerRecordList().get(0).getName()).isEqualTo("win");
    }

    @Test
    @DisplayName("2명의 승리자 조회 테스트")
    void getWinnerRecordList2() {
        List<Car> carList = Arrays.asList(new Car("win2"));
        carList.get(0).run(4);

        RacingHistory basicRacingHistory = getTestRacingHistory();
        basicRacingHistory.doRecord(2, carList);

        assertThat(basicRacingHistory.getWinnerRecordList().size()).isEqualTo(2);
    }
}