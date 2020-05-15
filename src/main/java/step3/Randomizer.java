package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizer {
    private Random random;

    Randomizer() {
        random = new Random();
    }

    public int generateNumber() {
        return random.nextInt(10);
    }

    public List<Integer> generateNumberList(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++)
            numbers.add(generateNumber());
        return numbers;
    }

}
