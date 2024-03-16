package domain;

@FunctionalInterface
public interface MoveStrategy {

    boolean moveable();

    boolean equals(Object o);
}
