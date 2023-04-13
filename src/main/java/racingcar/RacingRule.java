package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingRule {

    public static class RacingRandom {

        public static final int POWER_BOUND = 9;

        private static final Random RANDOM = new Random();

        public static List<Integer> randomNumbers(int length) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                numbers.add(nextInt());
            }
            return numbers;
        }

        private static int nextInt() {
            return RANDOM.nextInt(POWER_BOUND + 1);
        }

    }

    private static final int MOVABLE_POWER_CRITERIA = 4;

    public static List<Boolean> movableList(List<Integer> numbers) {
        List<Boolean> result = new ArrayList<>();
        for (int number : numbers) {
            result.add(isMovable(number));
        }
        return result;
    }

    private static boolean isMovable(int power) {
        return power >= MOVABLE_POWER_CRITERIA;
    }

}
