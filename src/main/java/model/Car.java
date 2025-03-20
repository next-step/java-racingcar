package model;

import strategy.MoveStrategy;
import strategy.RandomMoveStrategy;

public class Car {
    private String name;
    private int currentPosition = 1;
    private final MoveStrategy moveStrategy;

    public Car(String name) {
        this(name, new RandomMoveStrategy());
    }

    public Car(String name, MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new RuntimeException("moveStrategy 가 null입니다.");
        }

        if(name.length() > 5){
            throw new RuntimeException("name은 5자를 초과할 수 없습니다. name :" + name);
        }

        this.name = name;
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
