package step4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CarRacingUtil {
    private Random random;
    private int randomNumber;

    public CarRacingUtil() {
        random = new Random();
    }

    public static List<Car> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getRandomNumber() {
        randomNumber = random.nextInt(10);
        return randomNumber;
    }
}
