package CarRacing;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move() {
        this.position.move();
    }

    public int getCarPosition() {
        return this.position.getPosition();
    }

}
