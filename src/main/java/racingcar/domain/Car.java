package racingcar.domain;


import racingcar.service.strategy.MoveStrategy;

public interface Car {

    String getName();

    int getPosition();

    void move(MoveStrategy moveStrategy);

    boolean isSamePosition(int position);
}
