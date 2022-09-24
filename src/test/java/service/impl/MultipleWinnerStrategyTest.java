package service.impl;

import model.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MultipleWinnerStrategyTest {

    @Test
    void shouldPickMultipleWinner_whenPositionSame(){
        Car testCarA = Car.carWithName("testCarA");
        Car testCarB = Car.carWithName("testCarB");
        Car testCarC = Car.carWithName("testCarC");
        MultipleWinnerStrategy winnerStrategy = new MultipleWinnerStrategy();
        List<Car> winners = winnerStrategy.pickWinner(List.of(testCarA, testCarB, testCarC));
        assertThat(winners).containsExactly(testCarA,testCarB,testCarC);
    }

    @Test
    void shouldPickOneWinner_whenPositionDiff(){
        Car testCarA = Car.carWithName("testCarA");
        Car testCarB = Car.carWithName("testCarB");
        Car testCarC = Car.carWithName("testCarC");
        MultipleWinnerStrategy winnerStrategy = new MultipleWinnerStrategy();
        testCarA.move();
        List<Car> winners = winnerStrategy.pickWinner(List.of(testCarA, testCarB, testCarC));
        assertThat(winners).containsExactly(testCarA);
    }

}
