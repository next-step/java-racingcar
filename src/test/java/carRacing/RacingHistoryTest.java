package carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingHistoryTest {

    private RacingHistory getBasicRacingHistory(){
        RacingHistory racingHistory = new RacingHistory();

        Car winner = new Car("win");
        Car loser = new Car("lose");
        List<Car> carList = new ArrayList<>();
        carList.add(winner);
        carList.add(loser);

        racingHistory.doRecord(1, carList);

        winner.run(4);
        racingHistory.doRecord(2, carList);

        return racingHistory;
    }

    @Test
    @DisplayName("N 라운드의 경기 히스토리 조회 테스트")
    void getRecordList() {
        assertThat(getBasicRacingHistory().getRecordList(1).size()).isEqualTo(2);
    }


    @Test
    @DisplayName("마지막 라운드를 조회 테스트")
    void getLastRound() {
        assertThat(getBasicRacingHistory().getLastRound()).isEqualTo(2);
    }

    @Test
    @DisplayName("1명의 승리자 조회 테스트")
    void getWinnerRecordList1() {
        assertThat(getBasicRacingHistory().getWinnerRecordList().get(0).getName()).isEqualTo("win");
    }

    @Test
    @DisplayName("2명의 승리자 조회 테스트")
    void getWinnerRecordList2() {
        Car car = new Car("win2");
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        car.run(4);

        RacingHistory basicRacingHistory = getBasicRacingHistory();
        basicRacingHistory.doRecord(2, carList);

        assertThat(basicRacingHistory.getWinnerRecordList().size()).isEqualTo(2);
    }
}