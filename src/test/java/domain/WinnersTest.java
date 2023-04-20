package domain;


import static org.assertj.core.api.Assertions.assertThat;
import static view.ResultView.WINNER_DELIMITER;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {



    @Test
    @DisplayName("우승자의 이름 리스트를 가지고 온다.")
    void getFarthestDistance() {
        Car ethanCar = getCarWithMoved("ethan",3);
        Car rickCar = getCarWithMoved("rick",2);

        Cars cars = new Cars(List.of(ethanCar, rickCar));

        String winnerNames = new Winners(cars).makeWinnersString(WINNER_DELIMITER);
        assertThat(winnerNames).isEqualTo("ethan");
    }

    @Test
    @DisplayName("우승자의 이름은 복수일 수 있다.")
    void getWinnerNames(){
        Car ethanCar = getCarWithMoved("ethan",2);
        Car rickCar = getCarWithMoved("rick",2);

        Cars cars = new Cars(List.of(ethanCar, rickCar));
        Winners winners = new Winners(cars);

        String winnersNames = winners.makeWinnersString(WINNER_DELIMITER);

        Assertions.assertThat(winnersNames).isEqualTo("ethan, rick");
    }

    private static Car getCarWithMoved(String name, int movedCount) {
        Car car = new Car(name);
        for (int i = 0; i < movedCount; i++) {
            car.attemptMove(true);
        }
        return car;
    }
}
