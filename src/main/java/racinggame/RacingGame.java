package racinggame;

import java.util.Random;

public class RacingGame {
    private int[] cars;
    private int tryCnt;

    private static final int MAX_NUMBER = 9;
    private static final int POSSIBLE_NUMBER = 4;

    public RacingGame(int carCnt, int tryCnt){
        this.cars = new int[carCnt];
        this.tryCnt = tryCnt;
        for(int i=0; i < cars.length; i++){
            cars[i] = 0;
        }
    }

    public boolean nextRacingGame() {
        return tryCnt > 0;
    }

    public int[] move() {
        tryCnt--;
        for(int i =0; i < cars.length; i++){
            moveCar(i);
        }
        return cars;
    }

    private void moveCar(int location) {
        if(isPossibleMove()){
           cars[location]++;
        }
    }

    protected boolean isPossibleMove(){
        Random number = new Random();
        return number.nextInt(MAX_NUMBER) >= POSSIBLE_NUMBER;
    }

    public int[] getCars() {
        return cars;
    }

    public int getTryCnt() {
        return tryCnt;
    }


}
