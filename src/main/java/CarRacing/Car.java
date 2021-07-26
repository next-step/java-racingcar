package CarRacing;

import java.util.Objects;

public class Car {

    private Position position;

    public Car() {
        this.position = new Position();
    }

    public void move(int carMove) {
        this.position.move(carMove);
    }

    public int getCarPosition() {
        return this.position.getPosition();
    }

}
