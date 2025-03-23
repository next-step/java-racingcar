package carracing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Random;

public class RaceTest {

    @Test
    public void testPlayRoundMovesCarsAccordingToRandomNumbers() {
        RandomStub randomStub = new RandomStub(new int[]{4, 3, 4});
        Race race = new Race(3, new RandomMovingStrategy());
        race.playRound(randomStub);

        assertEquals(1, race.getCars().get(0).getPosition());
        assertEquals(0, race.getCars().get(1).getPosition());
        assertEquals(1, race.getCars().get(2).getPosition());
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
