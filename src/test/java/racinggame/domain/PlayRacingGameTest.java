package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayRacingGameTest {

    @DisplayName("우승자 확인")
    @Test
    public void winnerCheck() {

        Car car1 = new Car("a");
        Car car2 = new Car("b");

        car1.setLocation(5);
        car2.setLocation(8);
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        PlayRacingGame playRacingGame = new PlayRacingGame();
        List<Winner> winner = playRacingGame.findWinner(carList);

        Assertions.assertThat(winner.get(0).getWinnerName()).isEqualTo("b");


    }

}