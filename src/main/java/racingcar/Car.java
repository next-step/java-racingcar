package racingcar;

import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Car {
    private int number;
    private int distance;
    private Random random;

    Car(int number) {
        this.number = number;
        this.distance = 0;
        this.random = new Random();
    }

    public void progressRace() {
        if (runOrStop())
            distance++;
    }

    private boolean runOrStop() {
        return random.nextInt(10) >= 4;
    }

    public String printProgress() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, distance)
                .forEach( i ->
                        sb.append('-')
                );

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Car car = (Car) obj;
        return number == car.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
