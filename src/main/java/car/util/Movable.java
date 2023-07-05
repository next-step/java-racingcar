package car.util;

public abstract class Movable {
    boolean isMovable;

    abstract boolean decideMoving();
    public boolean getMovable() {
        return this.isMovable;
    }
    public abstract int getMovingSize();
}
