package carRacing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnerTest {

    private RacingCars cars;
    private int WINNER_POSITION = 5;

    @BeforeEach
    void setUp() {
        List<Car> carList = Arrays.asList(
                new Car("ferrari", WINNER_POSITION),
                new Car("bmw"),
                new Car("audi"));
        cars = new RacingCars(carList);
    }

    @Test
    @DisplayName("우승자 선정")
    public void pickWinnerTest() {
         RacingCars winners = RacingWinner.pickOutWinners(cars, WINNER_POSITION);
         assertThat(winners.getRacingCars()).containsExactly(new Car("ferrari"));
    }

}
