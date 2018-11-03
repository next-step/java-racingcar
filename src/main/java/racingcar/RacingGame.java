package racingcar;

import java.util.Random;

public class RacingGame {
    private int time;
    private int[] carPosition;

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
        int[] inputValues = InputView.input();
        RacingGame game = new RacingGame(inputValues[0], inputValues[1]);
        int[] carPosition = game.getCarPosition();
        int time = game.getTime();

        for(int i=0; i<time; i++){
            ResultView.result(move(carPosition));
        }
    }

    public static int[] move(int[] carPosition){
        for(int i=0; i<carPosition.length; i++) {
            movePerCarProcess(carPosition, i);
        }
        return carPosition;
    }

    public static void movePerCarProcess(int[] carPosition, int carSeq){
        if (movePossibleCheck()) {
            carPosition[carSeq] += 1;
        }
    }

    public static boolean movePossibleCheck(){
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if(randomNum >= 4){
            return true;
        }
        return false;
    }

}
