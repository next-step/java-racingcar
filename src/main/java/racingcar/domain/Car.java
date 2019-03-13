package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int ADVANCE_CONDITION = 3;
    private int position;

    private String name;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
    public void move(int newPosition) {
        if(ADVANCE_CONDITION < newPosition) {
            this.position += newPosition;
        }
    }

    public int compareTo(Car compareCar) { // override
        // 내림차순
        return compareCar.position - this.position;
    }
}
