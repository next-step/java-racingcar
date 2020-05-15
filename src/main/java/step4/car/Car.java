package step4.car;

public class Car {

    private int position;
    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public void move(MovingStrategy strategy) {
        if (strategy.canMove()) {
            this.position++;
        }
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void initPosition(){
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
