package study.racingcar.domain;

import study.racingcar.strategy.MoveStrategy;

import java.util.InputMismatchException;

public class Car {
    private static final int FIVE = 5;
    private String name;
    private int position;
    private MoveStrategy moveStrategy;

    public Car(int position, String name, MoveStrategy moveStrategy) {
        if(isMoreThanFiveLength(name)){
            this.name = name;
        }

        this.position = position;
        this.moveStrategy = moveStrategy;

    }

    public int currentPosition() {
        return this.position;
    }

    public void move() {

        if (moveStrategy.isMove()) {
            this.position = position + 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isPosition(int maxPosition) {

        return this.position == maxPosition;
    }

    private boolean isMoreThanFiveLength(String name) {

        if(name.length() > FIVE) {
            throw new InputMismatchException("자동차 이름이 5글자가 넘었습니다.");
        }

        return true;
    }
}
