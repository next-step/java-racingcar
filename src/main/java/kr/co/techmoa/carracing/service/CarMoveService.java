package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.Move;
import kr.co.techmoa.carracing.model.RacingCarGame;

import java.util.ArrayList;

public class CarMoveService {

    public static final int OPERATION_MAX = 10;
    public static final int ADVENCE_LIMIT = 4;
    public static final int FIRST_ROUND = 0;

    public RacingCarGame move(RacingCarGame racingCarGame) {

        int sum = 0;

        ArrayList roundList = new ArrayList<Car[]>();
        for(int i = 0 ; i < racingCarGame.getTryNumber() ; i++) {
            Car[] cars = new Car[racingCarGame.getCarNum()];
            for(int j = 0 ; j < cars.length ; j++) {
                cars[j] = new Car();
                int isAdvence = operator();
                cars[j].setMove(isAdvence);

                if(i != FIRST_ROUND) {
                    cars[j].setTotalMove(isAdvence + ((Car[])roundList.get(i-1))[j].getTotalMove());
                }else {
                    cars[j].setTotalMove(isAdvence);
                }
            }
            roundList.add(cars);
        }

        racingCarGame.setRounds(roundList);

        return racingCarGame;

    }

    private int operator() {

        int operatorSu = (int)(Math.random() * OPERATION_MAX);
        return isAdvence(operatorSu);

    }

    private int isAdvence(int operator) {
        if(operator < ADVENCE_LIMIT) {
            return Move.REVERSE.getCarMove();
        }
        return Move.ADVANCE.getCarMove();
    }



}
