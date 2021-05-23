package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racing.domain.RacingGame.SEPARATOR;


public class RacingGameTest {
    @DisplayName("첫번째 자동차인 aaa가 움직이면 우승차는 aaa 1대, 움직이지 않으면 6대 공동 우승")
    @Test
    public void findWinnerTest() {
        //given
        String carString = "aaa,bbb,ccc,ddd,eee,fff";
        String[] carNameArray = carString.split(SEPARATOR);
        List<Car> cars = new ArrayList<>();
        MoveConditionStrategy moveConditionStrategy = new OverFourStrategy();
        for (String carName : carNameArray) {
            cars.add(new Car(carName,moveConditionStrategy));
        }
        RacingGame racingGame = new RacingGame(cars);
        boolean isMove = racingGame.getCars().get(0).isMove();

        //when
        List<Car> winnerList = racingGame.findWinner();

        //then
        if(isMove) {
            assertAll(
                    () -> assertThat(winnerList.size()).isEqualTo(1),
                    () -> assertThat(winnerList.get(0).getName()).isEqualTo("aaa")
            );
        }
        if(!isMove){
            assertAll(
                    () -> assertThat(winnerList.size()).isEqualTo(6),
                    () -> assertThat(winnerList.get(0).getName()).isEqualTo("aaa")
            );
        }
    }
}
