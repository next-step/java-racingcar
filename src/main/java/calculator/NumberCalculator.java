package calculator;

import java.util.stream.IntStream;

public class NumberCalculator {

        private NumberCalculator() {
        }

        public static int sum(int[] numbers) {
                return IntStream.of(numbers).sum();
        }
}
