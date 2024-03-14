package step3;

import java.util.Scanner;

public class RacingApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요? ");
        int racingCarCount = scan.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요? ");
        int trials = scan.nextInt();

        Race race = new Race();
        Car[] carArray = race.generateCarArray(racingCarCount);
        // 게임 진행
        for (int turn = 0; turn < trials; turn++) {
            race.startMoving(carArray);
        }
    }
}
