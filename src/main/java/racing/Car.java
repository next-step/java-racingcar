package racing;

public class Car {

    private Position position;
    private CarName name;

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = new Position();
    }

    public static Car of(CarName carName, Position position) {
        return new Car(carName, position);
    }

    public void move(long l) {
        if (l >= 4)
            position.progress();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
