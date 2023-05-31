package edu.nextstep.camp.racing.model;

public class RacingStartInput {

    private static final int MIN_CAR = 2;
    private static final int MAX_CAR = 20;

    private static final int MIN_MOVING = 10;
    private static final int MAX_MOVING = 200;

    private final int vehicleCnt;
    private final int movingCnt;

    public RacingStartInput(String vehicleCnt, String movingCnt) {
        this.vehicleCnt = toPositive(vehicleCnt);
        this.movingCnt = toPositive(movingCnt);

        checkRange();
    }

        public int getMovingCnt() {
        return movingCnt;
    }

    public int getVehicleCnt() {
        return vehicleCnt;
    }

    private void checkRange(){
        if (!(MAX_CAR >= this.vehicleCnt && this.vehicleCnt >= MIN_CAR)) {
            throw new IllegalArgumentException("Please vehicle count input a number between " + MIN_CAR + " and " + MAX_CAR);
        }

        if (!(MAX_MOVING >= this.movingCnt && this.movingCnt >= MIN_MOVING)) {

            throw new IllegalArgumentException("Please moving count input a number between " + MIN_MOVING + " and " + MAX_MOVING);
        }
    }

    private int toPositive(String positiveNumerStr){
        int positiveNumer = Integer.parseInt(positiveNumerStr);

        if (positiveNumer < 0){
            throw new IllegalArgumentException("Please input a positive number.");
        }

        return positiveNumer;
    }





}
