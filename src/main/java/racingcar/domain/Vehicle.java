package racingcar.domain;

public interface Vehicle {

    Integer getPosition();

    void move(int number);
    String getName();

    Integer max(int other);

    boolean isMatch(int position);
    String toString();
}
