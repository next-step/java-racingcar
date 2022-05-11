package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    Random random = new Random();
    List<Integer> numbers;

    RandomNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public RandomNumbers(int count) {
        numbers = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            numbers.add(random.nextInt(10));
        }
    }

    boolean hasSize(int size) {
        return numbers.size() == size;
    }

    int get(int index) {
        return numbers.get(index);
    }
}
