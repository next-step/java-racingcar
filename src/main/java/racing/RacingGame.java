package racing;

import java.util.Random;

public class RacingGame {

    private int time = 0;
    private int[] carPositions = {0, 0, 0};

    RacingGame(){}

    RacingGame(int count, int time){
        readyCar(count);
        setTime(time);
    }

    public void setTime(int time){
        this.time = time;
    }
    public int getTime(){
        return time;
    }

    public int[] readyCar(int count){
        carPositions = new int[count];
        return carPositions;
    }
//InputView, ResultView와
    public int[] move() {
        for(int i = 0; i < carPositions.length; i++){
            tryMove(i);
        }
        return carPositions;
    }

    private void tryMove(int i) {
        if(isMove()){
           carPositions[i]++;
        }
    }

    private boolean isMove() {
        final int POSSIBLE_MOVE = 4;
        return getRandomNum() >= POSSIBLE_MOVE;
    }

    private int getRandomNum() {
        final int LIMIT_NUM = 10;
        Random random = new Random();
        return random.nextInt(LIMIT_NUM);
    }

    public static void main(String[] args){
        new ResultView(new InputView().getRacingGame()).watchRace();
    }


}
