package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class CarRacingGameTest {
    @Test
    @DisplayName("자동차 경주 게임에서 우승자를 찾을 수 있다.")
    public void canFindWinner() {
        List<Car> cars = List.of(
                new Car(1, "LEE"),
                new Car(3, "KIM"),
                new Car(3, "PARK"),
                new Car(2, "SON")
        );

        CarRacingGame carRacingGame = new CarRacingGame();
        assertThat(carRacingGame.findWinner(cars)).containsExactlyInAnyOrder("KIM", "PARK");
    }
}
