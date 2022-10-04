package carracing;

public interface MovableStrategy<T> {

    T getCondition();
    boolean predicate(T condition);
    default boolean canMove() {
        return predicate(getCondition());
    }
}
