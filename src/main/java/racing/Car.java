package racing;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private Position position;
    private CarName name;

    private Car(CarName name, Position position) {
        this.name = name;
        this.position = new Position();
    }

    public static Car of(CarName carName, Position position) {
        return new Car(carName, position);
    }

    void move(int condition) {
        if (condition >= MOVE_CONDITION)
            position.progress();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public boolean isWinner(int position) {
        return getPosition() == position;
    }

    public String getDistance() {
        return new String(new char[this.getPosition()]).replace("\0", "-");
    }
}
