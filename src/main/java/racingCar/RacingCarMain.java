package racingCar;

import java.util.Scanner;

import static racingCar.RacingCar.startingGame;

public class RacingCarMain {
    private static int time;
    private static int[] carPositions;

    public static void inputValue(){
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carPositions= new int[sc.nextInt()];
        System.out.println("시도할 횟수는 몇 회 인가요?");
        time = sc.nextInt();

    }

    public static void main(String[] args){
        inputValue();
        startingGame(time, carPositions);
    }
}
