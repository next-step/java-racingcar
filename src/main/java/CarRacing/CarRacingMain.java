package CarRacing;

import java.util.Scanner;

public class CarRacingMain {

    private static int carCount;
    private static int racingCount;
    private static CarRacing carRacing;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = sc.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        racingCount = sc.nextInt();

        carRacing = new CarRacing(carCount, racingCount);

        carRacing.raceStart();


    }
}
