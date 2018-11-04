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
        int[] carPosition = game.getCarPosition();
        int time = game.getTime();

        for(int i = 0; i < time; i++){
            ResultView.result(move(carPosition));
        }
    }

    public static int[] move(int[] carPosition){
        int idx = 0;
        for (int position: carPosition) {
            movePerCarProcess(carPosition, idx++);
        }
        return carPosition;
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

}
