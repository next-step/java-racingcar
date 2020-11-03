package study.step3.domain;

public interface Car {
    int NAME_MAX_LENGTH = 5;

    boolean isMoved();

    void move();

    String getName();
}
