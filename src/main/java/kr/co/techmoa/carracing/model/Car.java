package kr.co.techmoa.carracing.model;

import kr.co.techmoa.carracing.service.move.MoveStategy;
import kr.co.techmoa.carracing.service.move.RandomMoveStrategy;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Car {

    private Position position;
    private String carName;
    private CarEngine carEngine;

    public static final int CARNAME_MAX = 5;

    public Car(String carName) {
        if(carName.length() > CARNAME_MAX){
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.carName = carName;
        carEngine = new CarEngine();
        position = new Position(0);
    }

    public Car move(int moveCnt) {
        Position moveStep = new Position(moveCnt);
        this.position = position.plus(moveStep);
        return this;
    }

}
