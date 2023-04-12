package step3;

import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요??");
        int raceCount = scanner.nextInt();

        System.out.println("실행결과");
        Race.from(raceCount, carCount).race();

    }
}
