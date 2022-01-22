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
        int maxLocation=0;

        car1.updateLocation(5);
        car2.updateLocation(8);
        maxLocation=Math.max(car1.getLocation(),car2.getLocation());
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        PlayRacingGame playRacingGame = new PlayRacingGame();
        List<Winner> winner = playRacingGame.findWinner(carList,maxLocation);

        Assertions.assertThat(winner.get(0).getWinnerName()).isEqualTo("b");


    }

}