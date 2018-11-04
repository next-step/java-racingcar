package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private int time;
    private int[] carPositions;

    RacingGame(int count, int time){
        readyCar(count);
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    public int[] readyCar(int count){
        carPositions = new int[count];
        return carPositions;
    }

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
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView(sc);
        RacingGame racingGame = new RacingGame(inputView.getRacingCarCnt(), inputView.getTryCnt());
        ResultView.watchRace(racingGame);
    }


}
