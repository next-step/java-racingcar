package racing;

import java.util.Objects;

public class Car {
    private static final int AVAILABLE_RUN_THRESHOLD = 4;

    private int distance = 0;
    private String name = "";

    public Car(String name) {
        validName(name);
        this.name = name;
    }

    private void validName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("최대 5글자까지 입력 가능합니다.");
        }
    }

    public void run() {
        if (canRun()) { distance += 1; }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "distance=" + distance +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, name);
    }

    private static boolean canRun() {
        return generateRandom() >= AVAILABLE_RUN_THRESHOLD;
    }

    private static int generateRandom() {
        return (int)(Math.random() * 10) + 1;
    }
}
