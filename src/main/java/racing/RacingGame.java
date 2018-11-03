package racing;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {

    private int time = 0;
    private int[] carPositions = {0, 0, 0};
    Random random = new Random();

    RacingGame(){}

    RacingGame(int count, int time){
        readyCar(count);
        setTime(time);
    }

    public void setTime(int time){
        this.time = time;
    }

    public int[] readyCar(int count){
        carPositions = new int[count];
        return carPositions;
    }

    public int[] move() {
        for(int i = 0; i < carPositions.length; i++){
            goOrStop(i);
        }
        return carPositions;
    }

    private void goOrStop(int i) {
        if(random.nextInt(10) >= 4 ){
           carPositions[i]++;
        }
    }

    public void watchRace(){
        for (int i = 0 ; i < time; i++){
            move();
            watch();
        }

    }

    private void watch() {
        for(int j =0; j < carPositions.length; j++){
            draw(carPositions[j]);
        }
        System.out.println();
    }

    private void draw(int carPosition) {
        for (int k = 0; k < carPosition; k++) {
            System.out.print("-");
        }
        System.out.println();
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");

        int carCnt =  sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");

        int limitCnt = sc.nextInt();

        System.out.println("실행결과");

        RacingGame racingGame = new RacingGame(carCnt, limitCnt);

        racingGame.watchRace();

    }
}
