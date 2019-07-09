package racing.model;

public class Car {

    public static final int MOVE_CONDITION = 4;
    private Position position;
    private CarName name;

    private Car(CarName name) {
        this.name = name;
        this.position = new Position();
    }

    public static Car of(CarName carName) {
        return new Car(carName);
    }

    public void move(int condition) {
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
