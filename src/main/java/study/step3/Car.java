package study.step3;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position(0);
    }

    public void move(int condition) {
        if (condition >= 4) {
            position.forward();
        }
    }

    public Position getPosition() {
        return position;
    }
}
