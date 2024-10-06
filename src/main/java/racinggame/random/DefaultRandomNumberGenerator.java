package racinggame.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DefaultRandomNumberGenerator implements Radom{

    @Override
    public List<Integer> generate(int count) {
        return carCapacity(count);
    }
    private static List<Integer> carCapacity(int carCount) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int count = 0; count < carCount; count++) {
            result.add(random.nextInt(10));
        }
        return result;
    }
}
