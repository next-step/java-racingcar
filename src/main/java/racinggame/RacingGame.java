package racinggame;

import java.util.Random;

public class RacingGame {
    private int[] cars;
    private int tryCnt;

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
        return number.nextInt(9) >= 4;
    }

    public int[] getCars() {
        return cars;
    }

    public int getTryCnt() {
        return tryCnt;
    }


}
