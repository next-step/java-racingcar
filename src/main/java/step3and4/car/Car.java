package step3and4.car;

import step3and4.car.move.MoveStrategy;

public class Car implements Comparable {
    private int position = 0;
    private String name;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position += moveStrategy.move();
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public int compareTo(Object car) {
        if (car instanceof Car) {
            return compare((Car) car);
        }
        return 1;
    }

    private int compare(Car car) {
        if (this.position > car.position) {
            return 1;
        }
        if (this.position == car.position) {
            return 0;
        }
        return -1;
    }

    public boolean comparePosition(int position) {
        return this.position == position;
    }
}
