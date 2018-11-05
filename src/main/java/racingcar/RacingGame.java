package racingcar;

import java.util.Random;

public class RacingGame {
    private int time;
    private int[] carPosition;
    static final int MOVECHECK_NUM = 4;

    public int getTime(){
        return time;
    }

    public int[] getCarPosition(){
        return carPosition;
    }

    public RacingGame(int carCount, int time){
        this.time = time;
        this.carPosition = new int[carCount];
    }

    public static void main(String[] args){
        InputView in = new InputView();
        in.inputSetting();
        RacingGame game = new RacingGame(in.getCarCount(), in.getTime());

        game.move();
    }

    public int[] move(){
        for(int i = 0; i < time; i++){
            moveProcessByTime(carPosition);
            printCarPosition(carPosition);
        }
        return carPosition;
    }

    public static void moveProcessByTime(int[] carPosition){
        int idx = 0;
        for (int position: carPosition) {
            movePerCarProcess(carPosition, idx++);
        }
    }

    public static void movePerCarProcess(int[] carPosition, int idx){
        if (movePossibleCheck()) {
            carPosition[idx] += 1;
        }
    }

    public static boolean movePossibleCheck(){
        int randomNum = new Random().nextInt(10);
        return randomNum >= MOVECHECK_NUM;
    }

    public static void printCarPosition(int[] carPosition){
        ResultView.result(carPosition);
    }

}
