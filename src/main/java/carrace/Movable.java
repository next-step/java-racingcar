package carrace;

public interface Movable {
    default boolean isMovable() {
        return false;
    }
}
