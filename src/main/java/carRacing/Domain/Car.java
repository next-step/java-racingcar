package carRacing.Domain;


public class Car implements Vehicle {

    String name;
    int position;
    MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.position = 1;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (moveStrategy.movable()) {
            position++;
        }
    }

    public int greaterThen(int position) {
        return Math.max(this.position, position);
    }

    public int inquiryPosition() {
        return position;
    }
}
