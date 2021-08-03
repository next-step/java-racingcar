package kr.co.techmoa.carracing.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class Car {

    private int move;
    private int totalMove;
    private String carName;

    public Car(int move, int totalMove) {
        this.move = move;
        this.totalMove = totalMove;
    }
}
