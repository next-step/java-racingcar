package step2;

import java.util.Random;

public class RacingGame {

    private static int[] carPositions;
    private static final int STRAIGHT = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    private Random random = new Random();

    public void setInitPosition(int carQty){
        carPositions = new int[carQty];
    }

    public void startRacing(int carQty){

        for(int i=0; i < carQty; i++){
            carPositions[i] += move();
        }
    }

    private int move(){
        int randomNum = random.nextInt(10);
        if(STRAIGHT == randomNum){
            return GO;
        }
        return STOP;
    }

    public void resultView(){
        ResultView rv = new ResultView();
        rv.result(carPositions);
    }
}
