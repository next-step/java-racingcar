package racingcar.domain;

public class Car {

    private final String name;

    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void increaseDistance() {
        this.distance++;
    }

    public int distance() {
        return distance;
    }

    public String name() { return name; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + " : ");
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
