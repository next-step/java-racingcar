package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @DisplayName("입력받은 이름에 대해 차를 생성하고 이름을 부여할 수 있다.")
    @Test
    public void shouldNameAndCreateCars() throws Exception {
        //given
        String[] nameList = { "Tom", "Jerry", "Pinch" };
        //when
        Race.createCars(nameList);
        //then
        for (RacingCar racingCar : Race.racingCarList) {
            assertThat(racingCar.getName()).isIn(nameList);
        }
    }

    @DisplayName("자동차 이름이 5자를 초과하면 게임이 종료된다.")
    @Test
    public void shouldTerminateGame_whenExceed() throws Exception {
        //given
        String[] nameList = { "Tomass", "Jerry", "Pinch" };
        //when & then
        assertThatThrownBy(() -> {
            Race.createCars(nameList);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.")
    @Test
    public void shouldPrintCarName_whenPrintResult() throws Exception {
        //given
        String[] nameList = { "Tom", "Jerry", "Pinch" };
        int round = 1;
        //when
        Race.createCars(nameList);

        //then
        for (String result : Race.getEachResult()) {
            assertThat(result.split(" ")[0]).isIn(nameList);
        }
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.")
    @Test
    public void shouldNoticeWinner_whenRaceIsFinished() throws Exception {
        //given
        String[] nameList = { "Tom", "Jerry", "Pinch" };
        int round = 3;
        int winnerCountLowerBound = 1;
        //when
        Race.createCars(nameList);
        Race.playRace(round);
        List<String> winnerList = Race.getWinnerList();
        //then
        for (String winnerName : winnerList) {
            assertThat(winnerName).isIn(nameList);
        }
        assertThat(winnerList.size()).isGreaterThanOrEqualTo(winnerCountLowerBound);

    }

}
