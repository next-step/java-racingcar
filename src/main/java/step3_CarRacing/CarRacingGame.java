package step3_CarRacing;

import java.util.Scanner;

public class CarRacingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();
        scanner.nextLine(); // nextInt() 사용 후 nextLine() 호출 시 줄바꿈 문자 처리
        System.out.println("시도할 회수는 몇 회 인가요?");
        int numberOfTries = scanner.nextInt();
        System.out.printf("자동차 대수: %d, 시도할 회수: %d%n", numberOfCars, numberOfTries);
    }


}
