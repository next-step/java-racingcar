package study03;

import java.util.Scanner;

/*
*
* RacingClient
*
* @version 1.0.0
*
* 2021-11-07
*
* Copyright tnals1422
*/
public class RacingClient {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        String carCount = scanner.nextLine();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String tryCount = scanner.nextLine();

        new Racing(carCount, tryCount).start();
    }
}
