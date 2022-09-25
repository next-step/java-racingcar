package service.impl;

import model.Car;
import model.CarName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MultipleWinnerStrategyTest {

    @Test
    void shouldPickMultipleWinner_whenPositionSame() {
        Car testCarA = Car.carWithName(new CarName("testA"));
        Car testCarB = Car.carWithName(new CarName("testB"));
        Car testCarC = Car.carWithName(new CarName("testC"));
        MultipleWinnerStrategy winnerStrategy = new MultipleWinnerStrategy();

        List<Car> winners = winnerStrategy.pickWinner(List.of(testCarA, testCarB, testCarC));

        assertThat(winners).containsExactly(testCarA, testCarB, testCarC);
    }

    @Test
    void shouldPickOneWinner_whenPositionDiff() {
        Car testCarA = Car.carWithName(new CarName("testA"));
        Car testCarB = Car.carWithName(new CarName("testB"));
        Car testCarC = Car.carWithName(new CarName("testC"));
        MultipleWinnerStrategy winnerStrategy = new MultipleWinnerStrategy();

        testCarA.move();
        List<Car> winners = winnerStrategy.pickWinner(List.of(testCarA, testCarB, testCarC));

        assertThat(winners).containsExactly(testCarA);
    }
}

