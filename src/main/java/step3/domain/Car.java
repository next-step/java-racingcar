package step3.domain;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            position++;
        }
    }

    public boolean isMaxPosition(Car maxPositionCar) {
        return this.position == maxPositionCar.getPosition();
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car car) {
        if (this.position > car.getPosition()) {
            return 1;
        } else if (this.position < car.getPosition()) {
            return -1;
        }
        return 0;
    }
}
