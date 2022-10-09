package racing;

import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int carCount = 0;
        int gameCount = 0;

        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        gameCount = sc.nextInt();
    }
}
