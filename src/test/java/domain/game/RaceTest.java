package domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.cars.RacingCar;
import domain.request.RacingCarNameRequest;

public class RaceTest {

    @DisplayName("입력받은 이름에 대해 차를 생성하고 이름을 부여할 수 있다.")
    @Test
    public void shouldNameAndCreateCars() throws Exception {
        //given
        String[] names = { "Tom", "Jerry", "Pinch" };
        List<String> nameList = Arrays.asList(names);
        RacingCarNameRequest request = new RacingCarNameRequest(nameList);

        //when
        Race race = new Race(request);
        //then
        for (RacingCar racingCar : race.getRacingCars()) {
            assertThat(nameList).contains(racingCar.getName());
        }
    }

    @DisplayName("자동차 이름이 5자를 초과하면 게임이 종료된다.")
    @Test
    public void shouldTerminateGame_whenExceed() throws Exception {
        //given
        String[] names = { "Tomass", "Jerry", "Pinch" };
        List<String> nameList = Arrays.asList(names);
        RacingCarNameRequest request = new RacingCarNameRequest(nameList);
        //when & then
        assertThatThrownBy(() -> {
            Race race = new Race(request);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 우승자를 반환한다.")
    @Test
    void shouldGetWinner_AfterRace() {
        //given
        String bob = "bob";
        String woon = "Woon";
        RacingCar bobCar = new RacingCar(bob, 2);
        RacingCar woonCar = new RacingCar(woon, 3);
        Race race = new Race(Arrays.asList(bobCar, woonCar));
        //when
        List<String> winnerList = race.getWinners();
        //then
        assertThat(winnerList).containsOnly(woon);
    }

}
