package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static racing.domain.RacingGame.SEPARATOR;


public class RacingGameTest {
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
        racingGame.getCars().get(0).move(5);

        //when
        List<Car> winnerList = racingGame.findWinner();

        //then
        assertAll(
                () -> assertThat(winnerList.size()).isEqualTo(1),
                () -> assertThat(winnerList.get(0).getName()).isEqualTo("aaa")
        );
    }
}
