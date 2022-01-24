package racingcar.domain;


public interface Car {

    String getName();

    int getPosition();

    void moveForward();

    boolean isSamePosition(int position);
}
