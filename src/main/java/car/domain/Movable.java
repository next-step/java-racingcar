package car.domain;

abstract class Movable {
    boolean isMovable;

    abstract boolean decideMoving();
    boolean getMovable() {
        return this.isMovable;
    }
    abstract int getMovingSize();
}
