package carRacing;

import java.util.Scanner;

public class carRacing {
    public static void main(String[] args) {

        System.out.println("자동차 대수는 몇 대 인가요?");
        scanner();

        System.out.println("시도할 회수는 몇 회 인가요?");
        scanner();
    }

    private static void scanner() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}