package kr.co.techmoa.carracing.service;

import kr.co.techmoa.carracing.model.Car;
import kr.co.techmoa.carracing.model.Move;
import kr.co.techmoa.carracing.model.RacingCarGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarMoveService {

    public static final int OPERATION_MAX = 10;
    public static final int ADVENCE_LIMIT = 4;
    public static final int FIRST_ROUND = 0;

    public RacingCarGame move(RacingCarGame racingCarGame) {

        List<Car[]> roundList = new ArrayList<>();

        for(int i = 0 ; i < racingCarGame.getTryNumber() ; i++) {
            Car[] cars = new Car[racingCarGame.getCarNum()];
            moveOrder(i, roundList, cars);
            roundList.add(cars);
        }

        return RacingCarGame.builder()
                .carNum(racingCarGame.getCarNum())
                .carNames(racingCarGame.getCarNames())
                .rounds(racingCarGame.getRounds())
                .tryNumber(racingCarGame.getTryNumber())
                .build();

    }

    private int operator() {

        int operatorSu = new Random().nextInt(OPERATION_MAX);;

        return isAdvence(operatorSu);

    }

    private int isAdvence(int operator) {
        if(operator < ADVENCE_LIMIT) {
            return Move.REVERSE.getCarMove();
        }
        return Move.ADVANCE.getCarMove();
    }

    private Car[] moveOrder(int roundNum , List roundList, Car[] cars) {
        for(int j = 0 ; j < cars.length ; j++) {

            int isAdvence = operator();
            int sumTotalMove = calTotalMove(roundNum, isAdvence, roundList , j);
            cars[j] = new Car(isAdvence, sumTotalMove);

        }
        return cars;
    }

    private int calTotalMove(int roundNum , int isAdvence , List roundList , int carNum) {
        if(roundNum != FIRST_ROUND) {
            return isAdvence + ((Car[])roundList.get(roundNum-1))[carNum].getTotalMove();
        }
        return isAdvence;
    }


}
