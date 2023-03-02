package racingcar;

import java.util.Random;

public class racingCar {
    private String name;
    private Integer distance;
    private Random engine;

    public racingCar(String carName, int seed) {
        name = carName.toString();
        distance = 0;
        engine = new Random();
        engine.setSeed(System.currentTimeMillis() / seed);
    }

    public void drive() {
        int outputEngine = engine.nextInt(100000) % 9;

        if (4 > outputEngine)
            return;
        distance += 1;
    }

    public Comparable<Integer> getDistance() {
        return distance;
    }

    public String getStatus() {
        StringBuilder statusBuffer = new StringBuilder(name);
        statusBuffer.append(" : ");
        for (int ii = 0; ii < distance; ii++)
            statusBuffer.append("-");
        return statusBuffer.toString();
    }
}
