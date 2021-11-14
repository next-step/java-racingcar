package racing.basic.domain;

import java.util.Arrays;
import java.util.Random;

public class CarRacingGame {

    private Random  random;
    private Car[] track;

    public CarRacingGame(Random random, int lineCount) {
        this.random = random;
        track = new Car[lineCount];
        for (int i = 0; i < lineCount; i++) {
            track[i] = new Car();
        }
    }

    public int[] nextRound() {
        for (Car car : track) {
            int randomInteger = random.nextInt();
            car.moveOrStop(randomInteger);
        }
        return Arrays.stream(track)
                     .mapToInt(Car::toInteger)
                     .toArray();
    }
}
