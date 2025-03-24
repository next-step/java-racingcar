package carracing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class RaceTest {

    @Test
    @DisplayName("랜덤 값에 따라 자동차가 올바르게 이동하는지 확인")
    public void playRoundTest() {
        RandomStub randomStub = new RandomStub(new int[]{4, 3, 4});
        Race race = new Race(3, 1, new RandomMovingStrategy(randomStub));
        race.playRound();

        assertEquals(List.of(1, 0, 1), race.getCarPositions());
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
