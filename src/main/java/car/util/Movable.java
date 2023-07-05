package car.util;

public abstract class Movable {

    boolean isMovable;

    abstract public void decideMoving();

    public boolean getMovable() {
        return this.isMovable;
    }

    public abstract int getMovingSize();
}
