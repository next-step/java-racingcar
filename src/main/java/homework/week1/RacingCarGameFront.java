package homework.week1;

import java.util.Scanner;

public class RacingCarGameFront {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numbersOfCars = scanner.nextInt();
        System.out.println("경주 할 회수는 몇 회 인가요?");
        int numbersOfRacing = scanner.nextInt();
    }
}
