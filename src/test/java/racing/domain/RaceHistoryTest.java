package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.model.CarName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceHistoryTest
{
    private static final int FIRST_TURN = 1;
    private static final int SECOND_TURN = 2;

    private RaceHistory getTestRaceHistory() {
        RaceHistory history = new RaceHistory();

        List<Car> carList = Arrays.asList(new Car(CarName.from("win"), () -> true), new Car(CarName.from("lose"), () -> true));
        history.save(FIRST_TURN, carList);
        carList.get(0).moveForward();
        history.save(SECOND_TURN, carList);

        return history;
    }

    @Test
    @DisplayName("N 턴의 히스토리를 조회한다.")
    void getRecordList() {
        assertThat(getTestRaceHistory().getHistoryByTurn(1)).hasSize(2);
    }


    @Test
    @DisplayName("마지막 턴의 정보를 조회한다.")
    void getLastRound() {
        assertThat(getTestRaceHistory().getLastTurn()).isEqualTo(2);
    }

    @Test
    @DisplayName("1명의 winner를 확인한다.")
    void getWinnerRecordList1() {
        assertThat(getTestRaceHistory().getWinner()).isEqualTo("win");
    }

    @Test
    @DisplayName("2명의 winner를 확인한다.")
    void getWinnerRecordList2() {
        List<Car> carList = List.of(new Car(CarName.from("win2"), () -> true));
        carList.get(0).moveForward();

        RaceHistory basicRacingHistory = getTestRaceHistory();
        basicRacingHistory.save(2, carList);

        assertThat(basicRacingHistory.getWinner()).isEqualTo("win,win2");
    }
}
