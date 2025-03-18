package model;

import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class Car {
    private int currentPosition = 1;
    private final MoveStrategy moveStrategy;

    public Car() {
        moveStrategy = new RandomMoveStrategy();
    }

    public Car(MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new RuntimeException("moveStrategy 가 null입니다.");
        }

        this.moveStrategy = moveStrategy;
    }

    public void tryMove() {
        if (moveStrategy.canMove()) {
            this.currentPosition++;
        }
    }


    public void print() {
        System.out.print(getCurrentPositionDash());
        System.out.print("\n");
    }

    public String getCurrentPositionDash() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < currentPosition; i++) {
            result.append("-");
        }

        return result.toString();
    }
}
