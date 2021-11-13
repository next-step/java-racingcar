package racingcar.domain.model;

import racingcar.domain.strategy.MoveStrategy;

public class Car {

    private final Name name;
    private MoveHistory moveHistory;

    private Car(String name) {
        this.name = Name.from(name);
        this.moveHistory = MoveHistory.create();
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public void move(MoveStrategy moveStrategy) {
        moveHistory.addHistory(moveStrategy.isMove());
    }

    public long getHistorySuccessCount() {
        return moveHistory.getSuccessCount();
    }
    public long getHistorySuccessCount(int toIndex) {
        return moveHistory.getSuccessCount(toIndex);
    }

    public String getName() {
        return name.getName();
    }
}
