package kr.co.techmoa.carracing.model;

import kr.co.techmoa.carracing.service.move.MoveStategy;
import kr.co.techmoa.carracing.service.move.RandomMoveStrategy;

import java.util.Random;

public class CarEngine {

    public static final int ADVENCE_LIMIT = 4;

    public int operator(MoveStategy moveStategy) {
        int operatorSu = moveStategy.move();
        return isAdvence(operatorSu);
    }

    public int isAdvence(int operator) {
        if(operator < ADVENCE_LIMIT) {
            return Move.REVERSE.getCarMove();
        }
        return Move.ADVANCE.getCarMove();
    }
}
