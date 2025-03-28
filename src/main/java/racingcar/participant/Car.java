package racingcar.participant;


import java.util.Random;

public class Car implements Comparable<Car> {

    public static final Random RANDOM = new Random();
    private static final int MOVE_PROBABILITY = 4;
    private static final int TOTAL_PROBABILITY = 10;
    private final CarName name;
    private Integer distance = 0;
    private Integer playCount = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public Car(CarName name, Integer distance, Integer playCount) {
        this.name = name;
        this.distance = distance < 0 ? 0 : distance;
        this.playCount = playCount < 0 ? 0 : playCount;
    }


    public Integer getDistance() {
        return distance;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public Integer play() {
        playCount++;
        if (moveForwardOrNot()) {
            distance++;
        }
        return getDistance();
    }

    private static boolean moveForwardOrNot() {
        return RANDOM.nextInt(TOTAL_PROBABILITY) >= MOVE_PROBABILITY;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s: ", name.toString()));
        result.append("-".repeat(Math.max(0, getDistance())));
        return result.toString();
    }

    @Override
    public int compareTo(Car o) {
        return this.name.toString().compareTo(o.name.toString());
    }
}
