package racingcar;

import java.util.Scanner;

public class RacingMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int joinCar = 0;
        int move = 0;
    
        System.out.println("자동차 대수는 몇 대 인가요?");
        joinCar = sc.nextInt();
        System.out.println("시도할 횟수는 몇회 인가요?");
        move = sc.nextInt();

        
    }

}