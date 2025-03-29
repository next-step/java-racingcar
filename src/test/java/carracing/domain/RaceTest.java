package carracing.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RaceTest {

    @Test
    @DisplayName("자동차가 올바르게 경주하는지 확인")
    public void playRoundTest() {
        RandomStub randomStub = new RandomStub(new int[]{4, 3, 4});
        List<Car> testCars = List.of(
                new Car("TEST1"),
                new Car("TEST2"),
                new Car("TEST3")
        );
        Race race = new Race(testCars, 1, new RandomMovingStrategy(randomStub));
        race.playRound();

        assertEquals(List.of(1, 0, 1), race.getCarPositions());
    }

    @Test
    @DisplayName("우승자 검증 로직 확인")
    public void playRoundAndWinnersTest() {
        List<Car> testCars = List.of(
                new Car("TEST1", 1),
                new Car("TEST2", 0),
                new Car("TEST3", 1)
        );

        Race race = new Race(testCars, 1, null);

        List<String> winners = race.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        assertEquals(List.of("TEST1", "TEST3"), winners);
    }

    private static class RandomStub extends Random {
        private final int[] numbers;
        private int index;

        public RandomStub(int[] numbers) {
            this.numbers = numbers;
            this.index = 0;
        }

        @Override
        public int nextInt(int bound) {
            int value = numbers[index % numbers.length];
            index++;
            return value;
        }
    }
}
