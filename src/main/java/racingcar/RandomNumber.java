package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    public static final int BEGIN_INDEX = 0;

    public List<Integer> generateNumbers(int carCount) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = BEGIN_INDEX; i < carCount; i++){
            numbers.add(generateNumber());
        }
        return numbers;
    }

    private int generateNumber() {
        return new RandomGenerator().getRandomNumber();
    }
}
