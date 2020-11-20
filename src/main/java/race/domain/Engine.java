package race.domain;

@FunctionalInterface
public interface Engine {
    boolean canMove();

    Engine PERFECT_ENGINE = () -> true;
    Engine BROKEN_ENGINE  = () -> false;
}
